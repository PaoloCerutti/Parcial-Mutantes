# Parcial Mutantes

<h2>Tabla de Contenido</h2>

<h2>Descripción del Proyecto</h2>
<p>
	Se desarrolla una API que determina si una secuencia de ADN corresponde a un mutante. El sistema toma una cadena de ADN y utiliza reglas específicas para reconocer patrones mutantes. Además, genera estadísticas en tiempo real sobre la cantidad de secuencias de humanos y mutantes analizadas.
</p>

<h2>Las tecnologías que se usa para desarrollar el proyecto:</h2>
<p>
  
  <ul>
    <li><strong>Spring Boot</strong></li>
    <li><strong>Java 17</strong></li>  
    <li><strong>Gradle</strong> para la gestión de dependencias y automatización de compilaciones</li>
    <li><strong>H2 Database</strong> (base de datos en memoria) para persistencia de datos</li>
    <li><strong>JPA/Hibernate</strong> para manejo de la base de datos</li>
    <li><strong>Mockito y JUnit</strong> para pruebas unitarias</li>
    <li><strong>Cloud Platform</strong> Render para el despliegue en la nube</li>
    <li><strong>Docker</strong> Contenedores y despliegue</li>
      </ul>
</p>

<h2 >Instalación y Despliegue</h2>

<h3>Instalación</h3>
<ol>
  <li>Clona este repositorio:
    <pre><code>git clone https://github.com/PaoloCerutti/ParcialMutantes.git</code></pre>
  </li>
  <li>Navega al directorio del proyecto:
    <pre><code>cd parcialMutantes</code></pre>
  </li>
  <li>Compilar el proyecto:
    <pre><code>gradle build</code></pre>
  </li>
  <li>Ejecuta el proyecto usando Gradle:
    <pre><code>./gradlew bootRun</code></pre>
  </li>
</ol>

<h3 id="despliegue-en-la-nube">Despliegue en la nube</h3>
<p>
  El proyecto está desplegado en <a href="https://parcialmutantes-tsqw.onrender.com">Render</a>. Para acceder a la API en la nube:
</p>


<h2 id="uso">Uso</h2>

<h3 id="api-local-o-render">API Local o en Render</h3>
<p>
  Puedes interactuar con la API en dos entornos:
</p>
<ul>
  <li><strong>Local:</strong> Disponible en <code>http://localhost:8080/</code></li>
  
  <h4>JDBC URL: jdbc:h2:mem:testdb</h4>
  <h4>User Name: SA</h4>
  <h4>Password: </h4>

  <li><strong>Render:</strong> Disponible en <a href="https://parcialmutantes-tsqw.onrender.com">https://parcialmagneto-tsqw.onrender.com</a></li>
</ul>

<h4>Endpoints disponibles:</h4>
<ul>
  <li><strong>POST /mutant:</strong> Verifica si una secuencia de ADN es mutante.<a href="https://parcialmutantes-tsqw.onrender.com/mutant">https://parcialmagneto-tsqw.onrender.com/mutant</a></li>
</ul>
<pre><code>
{
  "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}
</code></pre>

<ul>
  <li><strong>GET /stats:</strong> Devuelve estadísticas sobre las verificaciones de ADN (proporción de mutantes/humanos).<a href="https://parcialmagneto-tsqw.onrender.com/stats">https://parcialmutantes-tsqw.onrender.com/stats</a></li>
</ul>

<p>
  El proyecto incluye pruebas unitarias para las funcionalidades principales. Para ejecutarlas, utiliza Gradle:
</p>
<pre><code>./gradlew test</code></pre>
<p>Los resultados de las pruebas se pueden encontrar en <code>build/reports/tests/test/index.html</code>.</p>


<h3>Petición para detectar si es mutante o no:</h3>
<pre><code>curl -X POST https://parcialmutantes-tsqw.onrender.com/mutant \
-H 'Content-Type: application/json' \
-d '{"dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]}'

</code></pre>

<h3>Respuesta para /stats:</h3>
<pre><code>{
  "count_mutant_dna": 40,
  "count_human_dna": 100,
  "ratio": 0.4
}
</code></pre>


