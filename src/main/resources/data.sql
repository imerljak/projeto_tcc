-- Initialize cargos
insert into cargo (id, nivel, nome) values
  ('ROLE_REVISOR_RELATOR', 1, 'Revisor/Relator'),
  ('ROLE_GERENTE', 2, 'Gerente'),
  ('ROLE_ADMINISTRADOR', 3, 'Administrador')
on conflict do nothing;

-- Insert Mock Concessionárias
insert into concessionaria (id, versao, cnpj, nome, telefone, email)
values
  (1, 9, '21879116000112', 'Major Chemicals', '20221713258', 'contact@majorchemicals.com'),
  (2, 4, '75125335000135', 'n/a', '14872807694', 'contact@mail.com'),
  (3, 48, '70175621000191', 'RETAIL: Building Materials', '45118982291', 'contact@mail.com'),
  (4, 99, '74003325000164', 'Semiconductors', '19963265047', 'contact@mail.com'),
  (5, 41, '73750526000162', 'Diversified Commercial Services', '95767079446', 'contact@mail.com'),
  (6, 100, '67120172000170', 'Mining & Quarrying of Nonmetallic Minerals (No Fuels)', '4242740978', 'contact@mail.com'),
  (7, 20, '37287271000180', 'Commercial Banks', '09202838624', 'contact@mail.com'),
  (8, 59, '28668884000176', 'n/a', '61762649935', 'contact@mail.com'),
  (9, 36, '25026769000100', 'Semiconductors', '51513529002', 'contact@mail.com'),
  (10, 60, '80818720000106', 'n/a', '69442048770', 'contact@mail.com')
on conflict do nothing;

-- Initialize tipos
INSERT INTO public.tipo (dtype, id, nome) VALUES
      ('SERVICO', 1, 'Transporte Público'),
      ('SERVICO', 2, 'Água e Esgoto'),
      ('DOCUMENTO', 3, 'Despacho Abertura'),
      ('DOCUMENTO', 4, 'Despacho Requerimento'),
      ('DOCUMENTO', 5, 'Despacho Decisões'),
      ('DOCUMENTO', 6, 'Notificação'),
      ('DOCUMENTO', 7, 'Oficio'),
      ('DOCUMENTO', 8, 'Auto de Infração'),
      ('DOCUMENTO', 9, 'Relatório'),
      ('PROCESSO', 10, 'Fiscalização'),
      ('PROCESSO', 11, 'Reajuste Tarifário'),
      ('PROCESSO', 12, 'Revisão Tarifária'),
      ('TRAMITE', 13, 'Abertura'),
      ('TRAMITE', 14, 'Fechamento')
on conflict do nothing;