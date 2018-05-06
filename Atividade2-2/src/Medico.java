
public class Medico {
	public void realizarCirurgia() {
		System.out.println("Medico realizou realizarCirurgia()");
	}
	public void realizarProcedimento() {
		System.out.println("Medico realizou realizarProcedimento()");
	}
	
	public static void main (String [] args) {
		Medico medico = new Medico();
		Doutor doutor = new Doutor();
		AdaptadorDoutor adaptadorDoutor = new AdaptadorDoutor(doutor);
		Medico[] medicos = new Medico[2];
		medicos[0]=medico;
		medicos[1]=adaptadorDoutor;
		medicos[0].realizarCirurgia();
		medicos[0].realizarProcedimento();
		medicos[1].realizarCirurgia();
		medicos[1].realizarProcedimento();
	}
}
