use SARES;

select Personal.nombres, Pedido.id, Count(Pedido.id) AS 'Canidad de platos'
From Personal, Pedido, Factura, Detalle_Factura, Detalle_Pedido
where 	Factura.TOTAL > 50
		and Detalle_Factura.id_factura = Factura.ID
		and Detalle_Factura.id_pedido = Detalle_Pedido.ID_Pedido
        and Pedido.id = Detalle_Pedido.ID_Pedido
		and Personal.cedula = Pedido.idMesero 
Group by Pedido.id
