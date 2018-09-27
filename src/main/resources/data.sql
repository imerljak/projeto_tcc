-- Initialize cargos
insert into cargo values ('ROLE_REVISOR_RELATOR', 1, 'Revisor/Relator')
on conflict do nothing;

insert into cargo values ('ROLE_GERENTE', 2, 'Gerente')
on conflict do nothing;

insert into cargo values ('ROLE_ADMINISTRADOR', 3, 'Administrador')
on conflict do nothing;