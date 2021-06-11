package entidad;

import java.sql.Date;

public class Cliente {
	private int idCliente;
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String categoria;
	private tipo_cliente tipo_cliente;
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public tipo_cliente getTipo_cliente() {
		return tipo_cliente;
	}
	public void setTipo_cliente(tipo_cliente tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCategoria() {
		categoria=tipo_cliente.getNombre();
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
