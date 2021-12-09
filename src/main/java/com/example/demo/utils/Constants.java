package com.example.demo.utils;

public class Constants {
    private static final String URL_API_BASE      = "/api";
    private static final String URL_API_VERSION   = "/v1";
    private static final String URL_BASE          = URL_API_BASE + URL_API_VERSION;
    public static final String URL_BASE_USUARIOS = String.format("%s/usuarios", URL_BASE);
    public static final String URL_BASE_PUESTOS = String.format("%s/puestos", URL_BASE);
    public static final String URL_BASE_MENU = String.format("%s/menu", URL_BASE);
    public static final String URL_BASE_ORDENES = String.format("%s/ordenes", URL_BASE);
    public static final String URL_BASE_PROVEEDORES = String.format("%s/proveedores", URL_BASE);
    public static final String URL_BASE_FACTURAS = String.format("%s/facturas", URL_BASE);
    public static final String URL_BASE_CLIENTES = String.format("%s/clientes",URL_BASE);
    public static final String URL_BASE_EMPLEADOS = String.format("%s/empleados",URL_BASE);
    public static final String URL_BASE_RESERVACIONES = String.format("%s/reservaciones",URL_BASE);
    public static final String URL_BASE_SUCURSALES = String.format("%s/sucursales",URL_BASE);
}
