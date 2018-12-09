Vue.filter('date', function (value) {
    return moment(String(value)).format('DD/MM/YYYY hh:mm')
});

Vue.component('table-pagination', {
    props: {
        current: {default: 0},
        total: {default: 0}
    },
    methods: {
        onPage: function (index) {
            this.$emit('page', index);
        }
    },
    template: '<nav v-if="total > 0" aria-label="page navigation">\n' +
        '              <ul class="pagination justify-content-end">' +
        '                  <li :class="{\'page-item\':true, active: (current === index)}" v-for="(n, index) in total">\n' +
        '                      <a class="page-link" @click="onPage(index)">{{n}}</a>\n' +
        '                  </li>\n' +
        '              </ul>\n' +
        '          </nav>'
});

Vue.component("paged-table", {
    props: ['url', 'columns'],
    data: function () {
        return {
            pageable: {}
        }
    },
    computed: {
        jsonColumns: function () {
            return JSON.parse(this.columns)
        }
    },
    created: function () {
        this.paginate(0);
    },
    methods: {
        toJson: function (data) {
            return JSON.parse(data);
        },
        paginate: function (page) {
            var instance = this;

            fetch(instance.url + '?page=' + page)
                .then(function (data) {
                    return data.json()
                })
                .then(function (data) {
                    instance.pageable = data;
                })
                .catch(function (reason) {
                    console.log(reason)
                })
        }
    },
    template: '<div>' +
        '          <div class="table-responsive">' +
        '              <table class="table table-striped table-hover">\n' +
        '                  <thead>\n' +
        '                     <tr>\n' +
        '                         <th v-for="column in toJson(columns)">{{ column.name }}</th>\n' +
        '                      </tr>\n' +
        '                  </thead>\n' +
        '                  <tbody>\n' +
        '                      <tr v-if="pageable.content === undefined || pageable.content.length === 0">' +
        '                          <td class="text-center" :colspan="jsonColumns.length"><slot name="empty-message">Nenhum registro encontrado</slot></td>' +
        '                          <td></td>' +
        '                      </tr>\n' +
        '                      <tr v-for="content in pageable.content">\n' +
        '                          <td v-for="column in toJson(columns)">\n' +
        '                              <template v-if="column.date">{{ content[column.index] | date }}</template>\n' +
        '                              <template v-else>{{ content[column.index] }}</template>\n' +
        '                          </td>\n' +
        '                      </tr>\n' +
        '                  </tbody>\n' +
        '              </table>' +
        '          </div>' +
        '          <table-pagination @page="paginate" v-bind:current="pageable.number" v-bind:total="pageable.totalPages"></table-pagination>\n' +
        '      </div>'
});