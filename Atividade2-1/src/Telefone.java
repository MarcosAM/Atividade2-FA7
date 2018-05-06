
// Resposta do item a) da primeira pergunta é padrão Observador!

public class Telefone implements ISubscrabable {
	IUpdatable[] ouvintes = new IUpdatable[10];
	
	@Override
	public void addSubscriber(IUpdatable subscriber) {
		for(int i=0;i<ouvintes.length;i++) {
			if(ouvintes[i]==null) {
				ouvintes[i]=subscriber;
				System.out.println("Subscriber adicionado!");
				return;
			}
		}
		System.out.println("Não foi possível adicionar um novo Subscriber. Remova algum!");
	}
	
	@Override
	public void removeSubscriber(IUpdatable subscriber) {
		for(int i=0;i<ouvintes.length;i++) {
			if(ouvintes[i]==subscriber) {
				ouvintes[i]=null;
				System.out.println("Subscriber removido!");
				return;
			}
		}
		System.out.println("Este subscriber não se encontra na lista!");
	}
	
	@Override
	public void updateSubscribers() {
		for(int i=0;i<ouvintes.length;i++) {
			if(ouvintes[i]!=null) {
				ouvintes[i].update();
			}
		}
	}
	
	public static void main (String[] args) {
		Telefone telefone = new Telefone();
		SecretariaEletronica secretariaEletronica = new SecretariaEletronica();
		Fax fax = new Fax();
		
		telefone.removeSubscriber(fax);
		telefone.addSubscriber(fax);
		telefone.addSubscriber(secretariaEletronica);
		telefone.updateSubscribers();
		telefone.removeSubscriber(fax);
		telefone.updateSubscribers();
	}
	
}
