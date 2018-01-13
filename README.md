# Iniciando com JPA
Criando uma aplicação simples para persistir com JPA.

## Passos
### 01. Implemente a entidade representada em UML. 
![pp](https://user-images.githubusercontent.com/23413093/34902950-d5beb198-f80d-11e7-99cc-1511a0bb72e7.png)

Determine um pacote para sua entidade e não esqueça dos construtores, gets e sets, toString e serializable.

```java
package dominio;
import java.io.Serializable;

public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	
	public Pessoa() {}

	public Pessoa(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}...

```

### 02. Implemente uma aplicação para criar os objetos Pessoa. 
Aqui vai o main.

```java
package aplicacao;
import dominio.Pessoa;

public class Aplicacao {

	public static void main(String[] args) {
	
		Pessoa pessoa1 = new Pessoa(1L, "Jack Bauer", "jb24@gmail.com");
		Pessoa pessoa2 = new Pessoa(2L, "Nina Meyers", "nina@gmail.com");
		Pessoa pessoa3 = new Pessoa(3L, "Ramón Salazar", "donramon@gmail.com");
		Pessoa pessoa4 = new Pessoa(4L, "David Palmer", "david_palmer@gmail.com");
		System.out.println(pessoa1);
		System.out.println(pessoa2);
		System.out.println(pessoa3);
		System.out.println(pessoa4);
	}
}
```

