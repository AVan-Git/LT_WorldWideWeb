# Hello everyone
# Good luck
## ở đây lưu file tài liệu môn Lập trình www và những source code demo theo bài



## 1 project Java EE

* create: 
    - Web Application - tomcat - gradle - vn.iuh.edu.fit.se - Artifact = "GK"
    - Web Profile 9.1
    - lib 
        mariadb
        //for logging
            implementation 'org.slf4j:slf4j-api:2.0.9'
            implementation 'org.slf4j:slf4j-simple:2.0.9'
        JPA
        // https://mvnrepository.com/artifact/org.mariadb.jdbc/mariadb-java-client
        implementation 'org.mariadb.jdbc:mariadb-java-client:3.2.0'
        // https://mvnrepository.com/artifact/org.eclipse.persistence/org.eclipse.persistence.jpa
        implementation 'org.eclipse.persistence:org.eclipse.persistence.jpa:4.0.2'

* persistence.xml:
    
    
        <persistence-unit name="lab_ontap" transaction-type="RESOURCE_LOCAL">
        
        <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
        <class>vn.iuh.edu.fit.se.model.Product</class>

        <exclude-unlisted-classes>false</exclude-unlisted-classes>


        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="org.mariadb.jdbc.Driver"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:mariadb://localhost:3307/mydb_ontap?createDatabaseIfNotExit=true"/>
            <property name="jakarta.persistence.jdbc.user" value="root"/>
            <property name="jakarta.persistence.jdbc.password" value="sapassword"/>
            <property name="jakarta.persistence.schema-generation.database.action" value="create"/>

            <!-- logging-->
            <property name="eclipselink.logging.level.sql" value="FINE"/>
            <property name="eclipselink.logging.parameters" value="true"/>
        </properties>



        </persistence-unit>

* entity:
    
    - 1 product => n productPrice
    - Jpa product
        @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
        private List<ProductPrice> productPrices;
    - jpa productPrice
        @ManyToOne
        @JoinColumn(name = "pro_id", nullable = false)
        private Product product;


* repository 

    - private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    - private EntityTransaction transaction;
    - contructor
        entityManager = Persistence.createEntityManagerFactory("labOnTap")
                .createEntityManager();
        transaction = entityManager.getTransaction();

    - TH co biến
        String sql = "SELECT p FROM Product p WHERE p.id =:id";
        TypedQuery<-Product> query = entityManager.createQuery(sql, Product.class);
            query.setParameter("id", maTim);
            a = query.getSingleResult();

        sql gộp bảng "select distinct c.id, c.fullName, c.email, c.phone from Candidate c join Experience e on c.id = e.candidate.id " +
                        "where e.roles = :selectedRole" 

* control servlet
    - href = "products?action=listProduct"
    - <%=hien_ra%>
    - <% tao bien %>
    - extend HttpServlet doGet()
        String action = req.getParameter("action");
        switch (action){
            case "listProduct":
            handleProductRequest(req,resp);
                break;
        }

        private void handleProductRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", productService.getAll() );
        req.getRequestDispatcher("products.jsp").forward(req,resp);
        }


