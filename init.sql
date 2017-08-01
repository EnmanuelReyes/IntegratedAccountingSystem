INSERT INTO accountingintegration.dbo.state (id_state, description) VALUES (1, 'Activo');


INSERT INTO accountingintegration.dbo.auxiliary (id_auxiliary, description, state_id_state) VALUES (1, 'Contabilidad', 1);
INSERT INTO accountingintegration.dbo.auxiliary (id_auxiliary, description, state_id_state) VALUES (2, 'Nomina', 1);
INSERT INTO accountingintegration.dbo.auxiliary (id_auxiliary, description, state_id_state) VALUES (3, 'Facturacion', 1);
INSERT INTO accountingintegration.dbo.auxiliary (id_auxiliary, description, state_id_state) VALUES (4, 'Inventario', 1);
INSERT INTO accountingintegration.dbo.auxiliary (id_auxiliary, description, state_id_state) VALUES (5, 'Cuentas x Cobrar', 1);
INSERT INTO accountingintegration.dbo.auxiliary (id_auxiliary, description, state_id_state) VALUES (6, 'Cuentas x Pagar', 1);
INSERT INTO accountingintegration.dbo.auxiliary (id_auxiliary, description, state_id_state) VALUES (7, 'Compras', 1);
INSERT INTO accountingintegration.dbo.auxiliary (id_auxiliary, description, state_id_state) VALUES (8, 'Activos Fijos', 1);
INSERT INTO accountingintegration.dbo.auxiliary (id_auxiliary, description, state_id_state) VALUES (9, 'Cheques', 1);



INSERT INTO accountingintegration.dbo.account_type (id_account_type, description, origin, state_id_state) VALUES (1, 'Activos', 'CREDIT', 1);
INSERT INTO accountingintegration.dbo.account_type (id_account_type, description, origin, state_id_state) VALUES (2, 'Pasivos', 'CREDIT', 1);
INSERT INTO accountingintegration.dbo.account_type (id_account_type, description, origin, state_id_state) VALUES (3, 'Capital', 'CREDIT', 1);
INSERT INTO accountingintegration.dbo.account_type (id_account_type, description, origin, state_id_state) VALUES (4, 'Ingresos', 'CREDIT', 1);
INSERT INTO accountingintegration.dbo.account_type (id_account_type, description, origin, state_id_state) VALUES (5, 'Costos', 'CREDIT', 1);
INSERT INTO accountingintegration.dbo.account_type (id_account_type, description, origin, state_id_state) VALUES (6, 'Gastos', 'CREDIT', 1);


INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (1, 0, 0.00, 'Activos', 1, 1, null, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (2, 0, 0.00, 'Efectivo en caja y banco', 2, 1, 1, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (3, 1, 0.00, 'Caja Chica', 3, 1, 2, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (4, 1, 0.00, 'Cuenta Corriente Banco x', 3, 1, 3, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (5, 0, 0.00, 'Inventarios y Mercancias', 2, 1, 1, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (6, 1, 0.00, 'Inventario', 3, 1, 5, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (7, 0, 0.00, 'Cuentas x Cobrar', 2, 1, 1, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (8, 1, 0.00, 'Cuentas x Cobrar Cliente X', 3, 1, 7, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (9, 0, 0.00, 'Cuenta mayor venta', 1, 1, 7, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (12, 0, 0.00, 'Ventas', 2, 4, 9, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (13, 1, 0.00, 'Ingresos x Ventas', 3, 4, 12, 1);


INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (47, 0, 0.00, 'Gastos', 1, 6, null, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (48, 0, 0.00, 'Gastos Administrativos', 2, 6, 47, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (50, 1, 0.00, 'Gastos Generales', 3, 6, 48, 1);




INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (65, 0, 0.00, 'Gasto depreciación Activos Fijos', 2, 6, 47, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (66, 1, 0.00, 'Depreciación Acumulada Activos Fijos', 3, 6, 65, 1);


INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (18, 0, 0.00, 'Cuenta Mayor Salarios y Sueldos Empleados', 2, 2, NULL, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (70, 1, 0.00, 'Salarios y Sueldos Empleados', 3, 2, 18, 1);


INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (58, 0, 0.00, 'Cuenta Mayor Gastos de Nomina Empresa', 2, 6, NULL, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (71, 1, 0.00, 'Gastos de Nomina Empresa', 3, 6, 58, 1);


INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (78, 0, 0.00, 'Cuenta Mayor Compra de Mercancias', 2, 5, NULL, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (80, 1, 0.00, 'Compra de Mercancias', 3, 5, 78, 1);


INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (19, 0, 0.00, 'Cuenta Mayor Cuentas x Pagar', 1, 2, NULL, 1);
INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (81, 0, 0.00, 'Cuentas x Pagar', 2, 2, 19, 1);


INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (82, 1, 0.00, 'Cuentas x Pagar Proveedor X', 3, 2, 81, 1);

INSERT INTO accountingintegration.dbo.accounting_account (id_accounting_account, allow_transactions, balance, description, level, account_type_id_account_type, major_account_id_accounting_account, state_id_state) VALUES (83, 1, 0.00, 'Cuentas Cheques en Banco X', 3, 1, 3, 1);





