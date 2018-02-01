INSERT INTO `SARES`.`Pedido` (`id`, `pagado`, `enPreparacion`, `cocinado`, `entregado`, `EnCola`, `preferencial`, `fechaHora`, `idCliente`, `idMesero`, `idCocinero`) VALUES ('11', '1', '0', '1', '1', '0', '1', '2018-01-19 20:00:00', '0986494824', '0912873456', '0921234567');
INSERT INTO `SARES`.`Pedido` (`id`, `pagado`, `enPreparacion`, `cocinado`, `entregado`, `EnCola`, `preferencial`, `fechaHora`, `idCliente`, `idMesero`, `idCocinero`) VALUES ('12', '1', '0', '1', '1', '0', '0', '2018-01-19 20:00:00', '0986494824', '0981237645', '0921234567');
INSERT INTO `SARES`.`Pedido` (`id`, `pagado`, `enPreparacion`, `cocinado`, `entregado`, `EnCola`, `preferencial`, `fechaHora`, `idCliente`, `idMesero`, `idCocinero`) VALUES ('13', '1', '0', '1', '1', '0', '1', '2018-01-19 20:00:00', '0986494824', '0912873456', '0921234567');
INSERT INTO `SARES`.`Pedido` (`id`, `pagado`, `enPreparacion`, `cocinado`, `entregado`, `EnCola`, `preferencial`, `fechaHora`, `idCliente`, `idMesero`, `idCocinero`) VALUES ('14', '1', '0', '1', '1', '0', '0', '2018-01-19 20:00:00', '0986494824', '0912873456', '0921234567');
INSERT INTO `SARES`.`Pedido` (`id`, `pagado`, `enPreparacion`, `cocinado`, `entregado`, `EnCola`, `preferencial`, `fechaHora`, `idCliente`, `idMesero`, `idCocinero`) VALUES ('15', '1', '0', '1', '1', '0', '1', '2018-01-19 20:00:00', '0986494824', '0912873456', '0921234567');
INSERT INTO `SARES`.`Pedido` (`id`, `pagado`, `enPreparacion`, `cocinado`, `entregado`, `EnCola`, `preferencial`, `fechaHora`, `idCliente`, `idMesero`, `idCocinero`) VALUES ('16', '1', '0', '1', '1', '0', '0', '2018-01-19 20:00:00', '0986494824', '0981237645', '0921234567');
INSERT INTO `SARES`.`Pedido` (`id`, `pagado`, `enPreparacion`, `cocinado`, `entregado`, `EnCola`, `preferencial`, `fechaHora`, `idCliente`, `idMesero`, `idCocinero`) VALUES ('17', '1', '0', '1', '1', '0', '1', '2018-01-19 20:00:00', '0986494824', '0912873456', '0921234567');
INSERT INTO `SARES`.`Pedido` (`id`, `pagado`, `enPreparacion`, `cocinado`, `entregado`, `EnCola`, `preferencial`, `fechaHora`, `idCliente`, `idMesero`, `idCocinero`) VALUES ('18', '1', '0', '1', '1', '0', '0', '2018-01-19 20:00:00', '0986494824', '0981237645', '0921234567');
INSERT INTO `SARES`.`Pedido` (`id`, `pagado`, `enPreparacion`, `cocinado`, `entregado`, `EnCola`, `preferencial`, `fechaHora`, `idCliente`, `idMesero`, `idCocinero`) VALUES ('19', '1', '0', '1', '1', '0', '1', '2018-01-19 20:00:00', '0986494824', '0912873456', '0921234567');
INSERT INTO `SARES`.`Pedido` (`id`, `pagado`, `enPreparacion`, `cocinado`, `entregado`, `EnCola`, `preferencial`, `fechaHora`, `idCliente`, `idMesero`, `idCocinero`) VALUES ('20', '1', '0', '1', '1', '0', '0', '2018-01-19 20:00:00', '0986494824', '0981237645', '0921234567');

INSERT INTO `SARES`.`Detalle_Pedido` (`ID_detalle`, `numDetalle`, `ID_Pedido`, `ID_Articulo`, `cantidad`, `Observaciones`) VALUES ('5', '1', '11', '4', '3', '');
INSERT INTO `SARES`.`Detalle_Pedido` (`ID_detalle`, `numDetalle`, `ID_Pedido`, `ID_Articulo`, `cantidad`, `Observaciones`) VALUES ('6', '2', '11', '2', '3', '');
INSERT INTO `SARES`.`Detalle_Pedido` (`ID_detalle`, `numDetalle`, `ID_Pedido`, `ID_Articulo`, `cantidad`, `Observaciones`) VALUES ('7', '1', '12', '4', '3', '');
INSERT INTO `SARES`.`Detalle_Pedido` (`ID_detalle`, `numDetalle`, `ID_Pedido`, `ID_Articulo`, `cantidad`, `Observaciones`) VALUES ('8', '1', '13', '2', '3', '');
INSERT INTO `SARES`.`Detalle_Pedido` (`ID_detalle`, `numDetalle`, `ID_Pedido`, `ID_Articulo`, `cantidad`, `Observaciones`) VALUES ('9', '2', '13', '4', '3', '');
INSERT INTO `SARES`.`Detalle_Pedido` (`ID_detalle`, `numDetalle`, `ID_Pedido`, `ID_Articulo`, `cantidad`, `Observaciones`) VALUES ('10', '1', '14', '2', '3', '');

INSERT INTO `SARES`.`Factura` (`ID`, `TOTAL`, `Fecha`, `Id_cliente`, `Descuento`, `TipoDePago`) VALUES ('3', '63', '2018-01-19', '0986494824', '0', '1');
INSERT INTO `SARES`.`Factura` (`ID`, `TOTAL`, `Fecha`, `Id_cliente`, `Descuento`, `TipoDePago`) VALUES ('4', '60', '2018-01-19', '0986494824', '0', '1');
INSERT INTO `SARES`.`Factura` (`ID`, `TOTAL`, `Fecha`, `Id_cliente`, `Descuento`, `TipoDePago`) VALUES ('5', '123', '2018-01-19', '0986494824', '0', '1');

INSERT INTO `SARES`.`Detalle_Factura` (`id_detalle`, `id_factura`, `id_pedido`) VALUES ('3', '3', '11');
INSERT INTO `SARES`.`Detalle_Factura` (`id_detalle`, `id_factura`, `id_pedido`) VALUES ('4', '4', '12');
INSERT INTO `SARES`.`Detalle_Factura` (`id_detalle`, `id_factura`, `id_pedido`) VALUES ('5', '5', '13');
INSERT INTO `SARES`.`Detalle_Factura` (`id_detalle`, `id_factura`, `id_pedido`) VALUES ('6', '5', '14');
