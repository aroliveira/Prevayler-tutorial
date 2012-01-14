package tutorial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.prevayler.Prevayler;
import org.prevayler.PrevaylerFactory;

import tutorial.transactional.AdicionaPessoa;

public class Main {

	   static Prevayler prevayler;  
	      
	   public static void main(String[] args) throws IOException, ClassNotFoundException {  
	         System.out.println("Iniciando Prevayler...");  
	  
	         PrevaylerFactory factory = new PrevaylerFactory();  
	         factory.configurePrevalenceDirectory("BASE");  
	         factory.configurePrevalentSystem(new ListaPessoas());  
	         prevayler = factory.create();  
	          
	         System.out.print("Digite nome da pessoa ou FIM para sair: ");  
	         String nome = lerTeclado();  
	         while (!nome.equals("FIM")) {  
	            try {  
	               prevayler.execute(new AdicionaPessoa(nome));  
	            } catch (Exception e1) {  
	               e1.printStackTrace();  
	            }  
	            System.out.println("Pessoa armazenada.");  
	            System.out.print("Digite o nome da pessoa ou FIM para sair: ");  
	            nome = lerTeclado();  
	         }  
	  
	         prevayler.takeSnapshot();  
             System.out.println("Snapshot disparado as " + new java.util.Date() + "...");   	         
	         
	         System.out.println("Imprimindo pessoas persistidas.");  
	         ListaPessoas lista = ((ListaPessoas) prevayler.prevalentSystem());  
	         for (int i = 0; i < lista.size(); i++) {  
	            System.out.println(lista.get(i).getNome());  
	         }  
	      }  
	  
	      public static String lerTeclado() {  
	         BufferedReader reader = new BufferedReader(new InputStreamReader(  
	                System.in));  
	         try {  
	            return reader.readLine();  
	         } catch (IOException e1) {  
	            return "FIM";  
	         }  
	      }  
	
}
