package tutorial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaPessoas implements Serializable {

	private static final long serialVersionUID = 2L;

	private List<Pessoa> listaPessoas = new ArrayList<Pessoa>();  
    
    public void add(Pessoa pes) {  
         listaPessoas.add(pes);  
     }  
     public Pessoa get(int i) {           
         return listaPessoas.get(i);  
     }  
     public int size() {  
        return listaPessoas.size();  
     }
}
