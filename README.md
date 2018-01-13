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
Agora precisamos persistir esses objetos.

### 03. Criar uma base de dados.
Certifique-se de ter em sua máquina as seguintes aplicações.
* [Wamp](http://www.wampserver.com/en/) ou [Xampp](https://www.apachefriends.org/pt_br/index.html)
* [MySQL](https://www.mysql.com/downloads/)

Após instalar o Wamp e o MySQL, inicie o Wamp e abra seu MySQL.

No MySQL crie um banco de dados 
```sql
create database iniciando_jpa;
```
### 04. Adicionar as bibliotecas Hibernate e MySQL Connector ao projeto.
Faça o download a seguir.

* [Download das bibliotecas](https://tinyurl.com/ybjfv4f8)

Em seu projeto, crie uma pasta chamada lib e descompacte o arquivo baixado nessa pasta (lib)
![pp](https://user-images.githubusercontent.com/23413093/34903396-ddb326ea-f817-11e7-8a16-f4caf8c9cd37.png)

Agora vamos configurar o projeto para que ele reconheça as bibliotecas que serão utilizadas.

* Clique com o botão direito em seu projeto

* Build Path ---> clique em -Configure Build Path...

![pp](https://user-images.githubusercontent.com/23413093/34903428-857cde66-f818-11e7-8b31-87c9a0d96897.png)

* Na aba Libraries clique no botão Add JARs...

* Localize os arquivos da pasta lib, selecione todos eles e clique em OK. 

* Em seguida clique em Apply and Close e pronto.

![pp](https://user-images.githubusercontent.com/23413093/34903465-365baf64-f819-11e7-947a-11a42739604a.png)

### 05. Configurar o JPA no projeto.

Agora vamos configurar o JPA no projeto através do arquivo persistence.xml

* Em seu projeto crie uma pasta chamada META-INF (tudo em maiúsculo mesmo) essa pasta deve ficar dentro da pasta src para que tudo dê certo.

* Em META-INF crie um arquivo chamado persistence.xml

![pp](https://user-images.githubusercontent.com/23413093/34903561-25d2e034-f81b-11e7-9cde-794b67e0a7dc.png)

* No arquivo persistence.xml cole o código de configuração a seguir.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
		xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
		http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
		version="2.1">
	<persistence-unit name="exemplo-jpa" transaction-type="RESOURCE_LOCAL">
		<properties>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/iniciando_jpa" />
			<property name="javax.persistence.jdbc.user" value="root" />
			<property name="javax.persistence.jdbc.password" value="" />
			<property name="hibernate.hbm2ddl.auto" value="update" />
		</properties>
	</persistence-unit>
</persistence>
```

### 06. Fazer o mapeamento da classe de domínio.

Agora iremos mapear as entidades com as notações JPA.

* @Entity - indica ao JPA que a classe é uma entidade que deve ser mapeada e a importação deve ser do javax
```java
import javax.persistence.Entity;
@Entity
public class Pessoa implements Serializable{
```

* @Id - indica que esse atributo é a chave primária do objeto
* @GeneratedValue(strategy=GenerationType.IDENTITY) - para o valor gerado por essa chave primária iremos usar a estratégia IDENTITY que deixa a criação dos Ids automatizada pelo banco de dados.
```java
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
```

* @Column(name="nomecompleto") - Renomeia o nome da coluna no banco. -indica ao JPA que, ao mapear esse atributo, lá no banco de dados a sua coluna será chamada de nomecompleto ao invés de nome como implementado na classe.
```java
@Column(name="nomecompleto")
private String nome;
```

### 07. Criar conexão com a base de dados.
Na aplicação do projeto temos que criar o EntityManager que faz a conexão e o acesso aos dados, e criar o EntityManagerFactory que é utilizado para criar o EntityManager.

* Na classe Aplicação, crie o EntityManagerFactory após as instâncias de Pessoa.
```java
//O parâmetro faz referência ao name da persistence-unit que criamos lá no persistence.xml
EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
```

* Em seguida crie o EntityManager dessa forma
```java
EntityManager em = emf.createEntityManager();
```
### 08. Persistir os objetos no banco de dados.
Para salvar os dados no banco é preciso alterar o parâmetro id para null lá na criação dos objetos, pois definimos como IDENTITY a geração dos ids.

```java
Pessoa pessoa1 = new Pessoa(null, "Jack Bauer", "jb24@gmail.com");
```
* Salvando os objetos
```java
//Abre a transação com o banco de dados
em.getTransaction().begin();
//Persiste os objetos
em.persist(pessoa1);
em.persist(pessoa2);
em.persist(pessoa3);
em.persist(pessoa4);
//Fecha a transação
em.getTransaction().commit();
```
Teste sua aplicação e verifique o seu banco de dados agora

![pp](https://user-images.githubusercontent.com/23413093/34908498-a4d44362-f877-11e7-9e5e-ed2f4c443302.png)
