package tutorial.transactional;

import java.io.Serializable;
import java.util.Date;

import org.prevayler.Transaction;

import tutorial.ListaPessoas;
import tutorial.Pessoa;

public class AdicionaPessoa implements Transaction, Serializable {  
   
	private static final long serialVersionUID = 3L;  
    
	private String nome;  
  
    public AdicionaPessoa(String nome) {  
        this.nome = nome;  
    }  
  
    public void executeOn(Object businessSystem, Date date) {  
        ((ListaPessoas) businessSystem).add(new Pessoa(nome));  
    }  
}  