package org.example;

import com.enums.TipoCuenta;
import com.enums.TipoDeMovimiento;
import com.enums.TipoPersona;
import com.models.*;
import com.models.funciones.Comercializar;
import com.models.funciones.Mensajes;
import com.models.funciones.Movimiento;
import com.models.funciones.Movimientos;

import javax.swing.*;
import java.util.Scanner;

public class Menu {
    private Scanner entrada = new Scanner(System.in);
    private Personas personas = new Personas();
    private Cuentas cuentas = new Cuentas();
    private Productos productos = new Productos();
    private Movimientos movimientos = new Movimientos();
    private PedidosList pedidosList;

    private Cliente clienteGenerica=new Cliente();
    private Proveedor proveedorGenerico= new Proveedor();
    private Cuenta cuentaGenerico = new Cuenta();
    private Movimiento movimientoGenerico = new Movimiento();
    private Producto producto = new Producto();
    private Pedido pedidoGenerico = new Pedido();

    TipoDeMovimiento tipoDeMovimiento;
    TipoPersona tipoPersona;
    TipoCuenta tipoCuenta;

    private int indexGenerico;
    private int opcion;
    private String DNIgenerico="";


    public Menu(PedidosList pedidosList, Personas personas, Cuentas cuentas, Productos productos, Movimientos movimientos) {

        this.personas = personas;
        this.cuentas = cuentas;
        this.productos = productos;
        this.movimientos = movimientos;
        this.pedidosList = pedidosList;
    }

    public void mostrarMenuPrincipal() {
        String[] opciones = { "Clientes", "Proveedores", "Pedidos", "Cuentas/Saldos", "Productos", "Salir" };
        int seleccion;
        do {
            seleccion = Mensajes.mensajeReturnIntConOpciones(opciones,"Menu Principal");
            switch (seleccion) {
                case 0 -> menuClientes();
                case 1 -> menuProveedores();
                case 2 -> menuPedidos();
                case 3 -> menuCuentas();
                case 4 -> menuProductos();
                case 5 -> JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (seleccion != 5);
    }

    private void menuClientes() {
        String[] opcionesClientes = { "Alta", "Baja (Personas)", "Modificación", "Buscar (Perspnas)", "Volver al menú principal" };
        int seleccion;
        do {
            seleccion = Mensajes.mensajeReturnIntConOpciones(opcionesClientes,"Menu Clientes");
            switch (seleccion) {
                case 0 -> altaCliente();
                case 1 -> bajaPersona();
                case 2 -> modificarCliente();
                case 3 -> buscarPersona();
                case 4 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (seleccion != 4);
    }

    private void altaCliente() {
        this.DNIgenerico = Mensajes.mensajeReturnString("Ingrese el DNI del cliente:");
        int index = this.personas.buscarIndexPorDNI(DNIgenerico);
        if(index == -1) {
            // ------------------- opcion cliente no esta (-1) ---------------
            clienteGenerica = new Cliente();
            clienteGenerica = clienteGenerica.crearCliente();
            if (clienteGenerica.mostrarCliente() == JOptionPane.YES_OPTION) {
                personas.addPersona(clienteGenerica);
                cuentas.cargarCuentasNuevaPersona(clienteGenerica);
                Mensajes.mensajeOut("Cliente registrado con éxito.");
                // No olvidarme de inicializar las variables usadas
            }

            int masClientes = Mensajes.mensajeYesNO("¿Quiere dar de alta más clientes?");
            if (masClientes == JOptionPane.YES_OPTION) {
                altaCliente();
            }
            //----------- fin de opcion cliente no esta

        }
        else {
            //--------- opcion index > -1 (esta) --------
            if(this.personas.buscarPersonaPorIndex(index).getTipoPersona() == TipoPersona.PROVEEDOR){
                if (Mensajes.mensajeYesNO("Existe un Proveedor con ese Numero. ¿Desea crear un clientes con ese numero?")
                        == JOptionPane.YES_OPTION) {
                    clienteGenerica = new Cliente();
                    clienteGenerica = clienteGenerica.crearCliente();
                    clienteGenerica.mostrarCliente();
                    if (Mensajes.mensajeYesNO("¿Confirma que los datos son correctos?") == JOptionPane.YES_OPTION) {
                        personas.addPersona(clienteGenerica);
                        Mensajes.mensajeOut("Cliente registrado con éxito.");
                    }
                    if (Mensajes.mensajeYesNO("¿Quiere dar de alta más clientes?") == JOptionPane.YES_OPTION) {
                        altaCliente();
                    }
                }
            }
            else{ // Existe ese DNI y no es de un proveedor entonces es de un Cliente
                Mensajes.mensajeOut("Ya existe un cliente con los datos solicitados.");
                if (Mensajes.mensajeYesNO("¿Desea modificar los datos?") == JOptionPane.YES_OPTION) {
                    modificarCliente();
                }
            }
            //-------------------- fin de opcion cliente no null (esta)
        }
        clienteGenerica = new Cliente();
        DNIgenerico = "";
    }

    private void bajaPersona() {
            DNIgenerico = Mensajes.mensajeReturnString("Ingrese el DNI del cliente a dar de baja:");
            int index = this.personas.buscarIndexPorDNI(DNIgenerico);
            if (index != -1) { // index >-1
            if (Mensajes.mensajeYesNO("¿Confirma la baja del cliente?") == JOptionPane.YES_OPTION) {
            this.personas.darBajaPersona(index);
            }
            Mensajes.mensajeOut("Cliente dado de baja con éxito.");
        }
            else { // index = -1
            Mensajes.mensajeOut( "No existe registro con ese DNI");
        }
            // No olvidarme de inicializar las variables usadas
            DNIgenerico = "";
    }
        private void modificarCliente() {
            DNIgenerico = Mensajes.mensajeReturnString("Ingrese el DNI del cliente a modificar:");
            indexGenerico = this.personas.buscarIndexPorDNI(DNIgenerico);
            if (indexGenerico == -1) {
                // cliente no encontrado (null)
                Mensajes.mensajeOut("Cliente no encontrado.");
            }

            else {// cliente encontrado (no -1)
                Mensajes.mensajeOut("Persona encontrada:");
                tipoPersona = personas.buscarPersonaPorIndex(indexGenerico).getTipoPersona();
                System.out.println(tipoPersona);
                if (tipoPersona == TipoPersona.CLIENTE){
                    clienteGenerica = (Cliente) personas.buscarPersonaPorIndex(indexGenerico);
                    clienteGenerica = Cliente.modificarCliente(clienteGenerica);
                    if (Mensajes.mensajeYesNO("¿Confirma la modificación?") == JOptionPane.YES_OPTION) {
                        personas.setPersonas(indexGenerico,clienteGenerica);
                        Mensajes.mensajeOut("Modifcado con Exito");}
                }
                else{
                    Mensajes.mensajeOut( "Existe pero: No es un Cliente, ES UN PROVEEDOR");
                }

            // fin de Persona encontrado
            }
            // No olvidarme de inicializar las variables usadas
            clienteGenerica = new Cliente();
            DNIgenerico = "";
            indexGenerico=0;
        }


    private void buscarPersona() {
        personas.buscarPersonaConMensajito();
    }

// ----------------proveedores

    private void menuProveedores() {
        String[] opcionesProveedores = { "Alta", "Baja", "Modificación", "Buscar", "Volver al menú principal" };
        int seleccion;
        do {
            seleccion = Mensajes.mensajeReturnIntConOpciones(opcionesProveedores, "Seleccione una opción para Proveedores");
            switch (seleccion) {
                case 0 -> altaProveedor();
                case 1 -> bajaPersona();
                case 2 -> modificarProveedor();
                case 3 -> buscarPersona();
                case 4 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (seleccion != 4);
    }

    //------------------------------ proveedores
    private void altaProveedor() {
        this.DNIgenerico = Mensajes.mensajeReturnString("Ingrese el DNI del cliente:");
        int index = this.personas.buscarIndexPorDNI(DNIgenerico);
        if(index == -1) {
            // ------------------- opcion cliente no esta (-1) ---------------
            proveedorGenerico = new Proveedor();
            proveedorGenerico = proveedorGenerico.crearProveedor();
            if (proveedorGenerico.mostrarProveedor() == JOptionPane.YES_OPTION) {
                personas.addPersona(proveedorGenerico);
                cuentas.cargarCuentasNuevaPersona(clienteGenerica);
                Mensajes.mensajeOut( "Proveedor registrado con éxito.");
            }

            if (Mensajes.mensajeYesNO("¿Quiere dar de alta más clientes?") == JOptionPane.YES_OPTION) {
                altaProveedor();
            }
            //----------- fin de opcion Proovedor no esta
        }
        else {
            //--------- opcion index > -1 (esta) --------
            if(this.personas.buscarPersonaPorIndex(index).getTipoPersona() == TipoPersona.CLIENTE){
                if (Mensajes.mensajeYesNO("Existe un Cliente con ese Numero. ¿Desea crear un proveedor con ese numero?") == JOptionPane.YES_OPTION) {
                    proveedorGenerico = new Proveedor();
                    proveedorGenerico = proveedorGenerico.crearProveedor();
                    if (proveedorGenerico.mostrarProveedor() == JOptionPane.YES_OPTION) {
                        personas.addPersona(proveedorGenerico);
                        Mensajes.mensajeOut( "Cliente registrado con éxito.");
                    }
                    if (Mensajes.mensajeYesNO("¿Quiere dar de alta más Clientes?") == JOptionPane.YES_OPTION) {
                        altaProveedor();
                    }
                }
            }
            else{ // Existe ese DNI y no es de un cliente entonces es de un proveedor
                Mensajes.mensajeOut("Ya existe un proveedor con los datos solicitados.");
                if (Mensajes.mensajeYesNO("¿Desea modificar los datos?") == JOptionPane.YES_OPTION) {
                    modificarProveedor();
                }
            }
            //-------------------- fin de opcion cliente no null (esta)
        }
        // No olvidarme de inicializar las variables usadas
        proveedorGenerico = new Proveedor();
        DNIgenerico = "";
    }

    //-----------------------
    private void modificarProveedor() {
        DNIgenerico = Mensajes.mensajeReturnString("Ingrese el DNI del cliente a modificar:");
        indexGenerico = this.personas.buscarIndexPorDNI(DNIgenerico);
        if (indexGenerico == -1) {
            // cliente no encontrado (null)
            Mensajes.mensajeOut("Cliente no encontrado.");
        }

        else {// cliente encontrado (no -1)
            Mensajes.mensajeOut("Persona encontrada:");
            tipoPersona = personas.buscarPersonaPorIndex(indexGenerico).getTipoPersona();
            System.out.println(tipoPersona);
            if (tipoPersona == TipoPersona.PROVEEDOR){
                proveedorGenerico = (Proveedor) personas.buscarPersonaPorIndex(indexGenerico);
                proveedorGenerico = Proveedor.modificarProveedor(proveedorGenerico);
                if (proveedorGenerico.mostrarProveedor() == JOptionPane.YES_OPTION) {
                    personas.setPersonas(indexGenerico,proveedorGenerico);}
            }
            else{
                Mensajes.mensajeOut("Existe pero: No es un Proveedor");
            }

            // fin de Persona encontrado
        }
        // No olvidarme de inicializar las variables usadas
        proveedorGenerico = new Proveedor();
        DNIgenerico = "";
        indexGenerico=0;
    }

    // Métodos similares para Pedidos, Cuentas/Saldos, y Productos...
    private void menuPedidos() {
        String[] opcionesPedidos = {
                "Crear pedido/movimiento",
                "Buscar Pedido (Pendiente/Ejecutado)",
                "Modificar/eliminar pedido Pendiente",
                "Ejecutar pedido Pendiente",
                "Listar Pedidos (Pendiente/Ejecutado)",
                "Anular movimiento",
                "Buscar Movimiento",
                "Listar Movimientos por Persona y fecha",
                "Volver al menú principal" };
        int seleccion;
        do {
            seleccion = Mensajes.mensajeReturnIntConOpciones(opcionesPedidos,"Menu Pedidos");
            switch (seleccion) {
                case 0 -> crearPedido(); /// crea un pedido y tambien la da opcion de ejecutarlo
                //case 1 -> buscarPedidos(); //escribirlo (abrir por fecha y persona)
                //case 2 -> modificarPedido(); //escribirlo tambien modifica o remueve solo no ejecutados
                //case 3 -> ejecutarPedido(); //escribirlo tambien modifica o remueve solo no ejecutados
                //case 4 -> ListarPedidos(); //escribirlo (abrir por fecha y persona)
                case 5 -> anularMovimiento(); // eliminar movimiento
                case 6 -> buscarUnMovimiento(); //escribirlo (abrir por fecha y persona)
                //case 7 -> ListarMovimientos(); //escribirlo (abrir por fecha y persona)
                case 8 -> Mensajes.mensajeOut("Volviendo al menú principal...");
                default -> Mensajes.mensajeOut( "Opción no válida");
            }
        } while (seleccion != 4);
    }

    private void anularMovimiento() {
        Comercializar.anularMovimientoMenus(movimientos, cuentas, productos, personas);
        if (Mensajes.mensajeYesNO("¿Quiere anular otro Movimiento?") == JOptionPane.YES_OPTION) {
            anularMovimiento();
        }
    }

    private void buscarUnMovimiento() {
        Comercializar.buscarMovimiento(movimientos,cuentas, productos,personas);
        if (Mensajes.mensajeYesNO("¿Quiere buscar otro Movimiento?") == JOptionPane.YES_OPTION) {
            buscarUnMovimiento();
    }
            }

    private void crearPedido() {

        cuentaGenerico = Comercializar.buscarCuenta(personas, cuentas);
        if (cuentaGenerico == null) {
            Mensajes.mensajeOut("No existe cuenta con esos requisitos");
        }
        if (cuentaGenerico != null) {
            tipoDeMovimiento = Mensajes.mensajeReturnEnumConOpciones(TipoDeMovimiento.class, "Tipo de Movimiento");
            pedidoGenerico = Comercializar.crearPedidoConDatosValidos(pedidosList, productos, tipoDeMovimiento, cuentaGenerico);

            Comercializar.aplicarMovimiento(productos, cuentas, movimientos, pedidoGenerico, pedidosList);
            cuentaGenerico = new Cuenta();
            DNIgenerico = "";
            pedidoGenerico = new Pedido();
        }
        if (Mensajes.mensajeYesNO("¿Quiere crear más Pedidos/Movimientos?") == JOptionPane.YES_OPTION) {
            crearPedido();

        }
    }


    private void modificarPedido() {

        if (Mensajes.mensajeYesNO("¿Quiere modificar mas Pedidos?") == JOptionPane.YES_OPTION) {
            modificarPedido();
        }
    }

    private void eliminarPedido() {
        Comercializar.anularMovimientoMenus(movimientos,cuentas, productos,personas);
        if (Mensajes.mensajeYesNO("\"¿Quiere anular más Movimientos?\"") == JOptionPane.YES_OPTION) {
            eliminarPedido();
        }
    }


    private void buscarPedidos() {

        if (Mensajes.mensajeYesNO("\"¿Quiere buscar más pedidos?\"") == JOptionPane.YES_OPTION) {
            buscarPedidos();
        }
    }

    private void menuCuentas() {
                String[] opcionesCuentas = {
                        "Activar Cuenta",
                        "Baja Cuenta",
                        "Ver Saldo de Cuenta por Personas",
                        "Listar Cuentas (Activas/Pasivas/Todas)",
                        "Volver al menú principal"};
                int seleccion;
                do {
                    seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción para Cuentas/Saldos",
                            "Menú Cuentas/Saldos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                            opcionesCuentas, opcionesCuentas[0]);
                    switch (seleccion) {
                        //case 0 -> activarCuenta();
                        //case 1 -> bajaCuenta();
                        //case 2 -> verSaldoCuentaPersonas();
                        //case 3 -> listarCuentas();
                        case 4 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                        default -> JOptionPane.showMessageDialog(null, "Opción no válida");
                    }
                } while (seleccion != 4);
    }

    private void activarCuenta() {

        if (Mensajes.mensajeYesNO("¿Quiere Activar otra cuenta más pedidos?") == JOptionPane.YES_OPTION) {
            activarCuenta();
        }
    }

    private void bajaCuenta() {

        if (Mensajes.mensajeYesNO("¿Quiere Activar otra cuenta?") == JOptionPane.YES_OPTION) {
            activarCuenta();
        }
    }

    private void verSaldoCuentaPersonas() {

        if (Mensajes.mensajeYesNO("¿Quiere ver el saldo de otra Persona?") == JOptionPane.YES_OPTION) {
            verSaldoCuentaPersonas();
        }
    }


    private void listarCuentas() {

        if (Mensajes.mensajeYesNO("¿Quiere ver el saldo de otra Persona?") == JOptionPane.YES_OPTION) {
            verSaldoCuentaPersonas();
        }
    }


    private void menuProductos() {
        String[] opcionesProductos = {
                "Alta",
                "Baja",
                "Modificación",
                "Listado",
                "Buscar por producto",
                "Buscar por proveedor",
                "Volver al menú principal" };
        int seleccion;
        do {
            seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción para Productos",
                    "Menú Productos", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    opcionesProductos, opcionesProductos[0]);
            switch (seleccion) {
                case 0 -> altaProducto();
                case 1 -> bajaProducto();
                case 2 -> modificarProducto();
                case 3 -> listadoProductos();
                case 4 -> buscarPorProducto();
                case 5 -> buscarPorProveedor();
                case 6 -> JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (seleccion != 6);
    }

    private void altaProducto() {
        String producto = JOptionPane.showInputDialog("Ingrese el nombre del nuevo producto:");
        JOptionPane.showMessageDialog(null, "Producto " + producto + " dado de alta.");
    }

    private void bajaProducto() {
        String producto = JOptionPane.showInputDialog("Ingrese el nombre del producto a dar de baja:");
        JOptionPane.showMessageDialog(null, "Producto " + producto + " dado de baja.");
    }

    private void modificarProducto() {
        String producto = JOptionPane.showInputDialog("Ingrese el nombre del producto a modificar:");
        String nuevoDato = JOptionPane.showInputDialog("Ingrese el nuevo dato del producto:");
        JOptionPane.showMessageDialog(null, "Producto modificado: " + nuevoDato);
    }

    private void listadoProductos() {
        JOptionPane.showMessageDialog(null, "Mostrando listado de productos...");
    }

    private void buscarPorProducto() {
        String productoNombre = JOptionPane.showInputDialog("Ingrese el nombre del producto a buscar:");
        JOptionPane.showMessageDialog(null, "Mostrando información del producto: " + producto);
        productos.mostrarProductos(productoNombre);
    }

    private void buscarPorProveedor() {
        String proveedor = JOptionPane.showInputDialog("Ingrese el nombre del proveedor:");
        JOptionPane.showMessageDialog(null, "Mostrando productos del proveedor: " + proveedor);
    }


}
