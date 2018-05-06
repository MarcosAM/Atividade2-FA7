
public class EmailManager {
	public String nome;
	
	public static void main (String[] args) {
		EmailManager emailManager = new EmailManager();
		emailManager.nome = "Joãozim";
		emailManager.SendEmailTo("mariazinha@gmail.com", "Olá, Mariazinha!");
		emailManager.SendEmailTo("mariazinha@gmail.com", "Olá, Mariazinha!", new IAttachmentable () {public void showAttachment() {System.out.println("Imagem de gatinhos");}});
	}
	
	public void SendEmailTo (String email, String mensagem) {
		Email newEmail = new Email();
		newEmail.nomeRemetente = nome;
		newEmail.mensagem = newEmail.new Mensagem(mensagem);
		newEmail.destinos[0] = newEmail.new Destino(newEmail);
		newEmail.destinos[0].name = email;
		newEmail.destinos[0].send();
	}
	
	public void SendEmailTo (String email, String mensagem, IAttachmentable anexo) {
		Email newEmail = new Email();
		newEmail.nomeRemetente = nome;
		newEmail.mensagem = newEmail.new Mensagem(mensagem);
		newEmail.mensagem.anexos[0] = anexo;
		newEmail.destinos[0] = newEmail.new Destino(newEmail);
		newEmail.destinos[0].name = email;
		newEmail.destinos[0].send();
	}
	
	public class Email {
		
		public String nomeRemetente;
		public String assunto;
		public Mensagem mensagem;
		public Destino[] destinos = new Destino[20];
	
		public class Destino {
			public String name;
			public String emailAddress;
			Email email;
			
			public void send() {
				System.out.println("Enviar mensagem de "+ email.nomeRemetente+" para "+name);
				System.out.println(email.mensagem.corpo);
				for(int i=0;i<email.mensagem.anexos.length;i++ ) {
					if(email.mensagem.anexos[i] != null) {
						email.mensagem.anexos[i].showAttachment();
					}
				}
			}
			
			public void showItself() {
				System.out.println("Esse e-mail é para "+emailAddress);
			}
			
			Destino(){};
			
			Destino(Email email){
				this.email = email;
			}
		}
		
		public class DestinoOculto extends EmailManager.Email.Destino{
			@Override
			public void showItself() {
				System.out.println("Cannot show itself!");
			}
		}
		
		class Mensagem{
			public String corpo;
			public IAttachmentable[] anexos = new IAttachmentable[10];
			
			Mensagem(String corpo) {
				this.corpo = corpo;
			}
		}
	}
	
	interface IAttachmentable{
		public void showAttachment();
	}
	
}
