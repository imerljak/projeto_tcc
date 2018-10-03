-- Initialize cargos
insert into cargo values
  ('ROLE_REVISOR_RELATOR', 1, 'Revisor/Relator'),
  ('ROLE_GERENTE', 2, 'Gerente'),
  ('ROLE_ADMINISTRADOR', 3, 'Administrador')
on conflict do nothing;

-- Insert Mock Concessionárias
insert into concessionaria (id, criado_por, data_criacao, data_ultima_atualizacao, versao, cnpj, nome, telefone, email)
values
  (1, 1, '2018-04-04 20:44:57', null, 9, '61422442887055', 'Major Chemicals', '20221713258',
   'contact@majorchemicals.com'),
  (2, 1, '2018-08-28 06:12:37', '2017-11-01 21:54:53', 4, '97499760480772', 'n/a', '14872807694', 'contact@mail.com'),
  (3, 1, '2017-12-30 11:47:59', '2018-02-27 16:52:43', 48, '81351621301866', 'RETAIL: Building Materials',
   '45118982291', 'contact@mail.com'),
  (4, 1, '2018-04-02 13:56:05', '2018-07-19 06:23:41', 99, '85741963704470', 'Semiconductors', '19963265047',
   'contact@mail.com'),
  (5, 1, '2018-08-13 06:37:46', '2018-09-23 15:00:22', 41, '67648415561041', 'Diversified Commercial Services',
   '95767079446', 'contact@mail.com'),
  (6, 1, '2017-12-06 23:41:52', '2018-01-20 16:07:51', 100, '28862692387123',
   'Mining & Quarrying of Nonmetallic Minerals (No Fuels)', '4242740978', 'contact@mail.com'),
  (7, 1, '2017-10-14 03:12:41', '2017-12-25 10:28:50', 20, '27613238088156', 'Commercial Banks', '09202838624',
   'contact@mail.com'),
  (8, 1, '2018-05-30 01:32:15', null, 59, '64919949201829', 'n/a', '61762649935', 'contact@mail.com'),
  (9, 1, '2018-05-29 05:33:46', null, 36, '41138796378347', 'Semiconductors', '51513529002', 'contact@mail.com'),
  (10, 1, '2018-05-15 20:52:11', '2018-08-17 10:50:55', 60, '14579927907095', 'n/a', '69442048770', 'contact@mail.com')
on conflict do nothing;

-- Insert Root user
INSERT INTO public.usuario (id, criado_por, data_criacao, data_ultima_atualizacao, ultima_atualizacao_por, versao, ativo, email, nome, senha)
VALUES (16, 'anonymousUser', '2018-10-03 18:05:11.492000', '2018-10-03 18:05:11.492000', 'anonymousUser', 0, true,
        'imerljak@gmail.com', 'Israel Merljak', '$2a$10$qVH./f6KjoBQ0ay7MvIvHORHS64Od.EaGH2OAnZbfoc4U9j8lNiZ2')
on conflict do nothing;

-- Initialize tipos
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('SERVICO', 1, null, 'Transporte Público')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('SERVICO', 2, null, 'Água e Esgoto')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('DOCUMENTO', 3, null, 'Despacho Abertura')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('DOCUMENTO', 4, null, 'Despacho Requerimento')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('DOCUMENTO', 5, null, 'Despacho Decisões')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('DOCUMENTO', 6, null, 'Notificação')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('DOCUMENTO', 7, null, 'Oficio')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('DOCUMENTO', 8, null, 'Auto de Infração')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('DOCUMENTO', 9, null, 'Relatório')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('PROCESSO', 10, null, 'Fiscalização')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('PROCESSO', 11, null, 'Reajuste Tarifário')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('PROCESSO', 12, null, 'Revisão Tarifária')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('TRAMITE', 13, null, 'Abertura')
on conflict do nothing;
INSERT INTO public.tipo (dtype, id, descricao, nome) VALUES ('TRAMITE', 14, null, 'Fechamento')
on conflict do nothing;