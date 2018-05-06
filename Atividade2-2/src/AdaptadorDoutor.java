
public class AdaptadorDoutor extends Medico {
	private Doutor doutorAdaptado;
	
	@Override
	public void realizarCirurgia() {
		doutorAdaptado.operar();
	}
	
	@Override
	public void realizarProcedimento() {
		doutorAdaptado.fazerProced();
	}
	
	AdaptadorDoutor (Doutor doutorAdaptado){
		this.doutorAdaptado = doutorAdaptado;
	}
}
