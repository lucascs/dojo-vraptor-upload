<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul>
<c:forEach items="${arquivos}" var="arquivo">
	<li><a href="/dojo/arquivos/${arquivo.nome }">${arquivo.nome}</a>
		<form action="/dojo/arquivos/${arquivo.nome }" method="post">
			<input type="hidden" name="_method" value="delete"/>
			<input type="submit" value="Remove"/> 
		</form>
	</li>
</c:forEach>
</ul>
