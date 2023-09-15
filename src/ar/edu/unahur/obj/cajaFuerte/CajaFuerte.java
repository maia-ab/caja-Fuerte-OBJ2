package ar.edu.unahur.obj.cajaFuerte;

public class CajaFuerte {
	private Boolean estaAbierta = Boolean.TRUE;
    private int claveMaestra;
    private int claveID;
    private Boolean estaBloqueada = Boolean.FALSE;
    private Integer intentosDeAbrir = 0;
	
	public CajaFuerte(int claveDeInicio) {
		this.claveMaestra = claveDeInicio;
	}
	public Boolean estaAbierta() {
		// TODO Auto-generated method stub
		return estaAbierta;
	}
	public void cerrar() {
		this.estaAbierta = Boolean.FALSE;
		
	}

	public void abrir() {
		this.estaAbierta = Boolean.TRUE;
	}
	public void abrirConClave(int claveIngresada) {
		if(!(this.estaBloqueada)) {
			if(this.claveMaestra == claveIngresada || this.claveID == claveIngresada) {
				this.abrir();
				if (this.claveMaestra == claveIngresada){
					this.bloquear();
				}
			}else {
				this.intentosDeAbrir += 1;
				if (intentosDeAbrir == 3) {
					this.bloquear();
				}
			}
			
		}

	}
	
	public void bloquear() {
		this.estaBloqueada = Boolean.TRUE;
	}
	
	public void desbloquear() {
		this.estaBloqueada = Boolean.FALSE;
	}
	
	public void cambiarClave(int claveIngresada1, int claveIngresada2) {
		if(claveIngresada1 == this.claveMaestra) {
			this.claveID = claveIngresada2;
			this.desbloquear();
		}
		
	}
	public Boolean estaBloqueada() {
		return this.estaBloqueada;
	}


}
