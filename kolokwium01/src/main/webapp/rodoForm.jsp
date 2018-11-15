<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rodo</title>
    <link rel="stylesheet" href="source/style.css">
</head>
<body>

        <form action="rodoCheck">
            <h1>Musisz zaakceptowac polityke prywatnosci, aby dokonac zakupu!</h1><br>
            <input type="checkbox" name="rodo" value="rodoBuy" required="required">Akceptuje polityke prywatnosci.<br>
            Imie:<input type="text" name="name" required="required"><br>
            Nazwisko:<input type="text" name="surname" required="required"><br>
            Email:<input type="text" name="email" required="required"><br>
			<input type="checkbox" name="doesEmail" value="horses">Chce otrzymwac nowe informacje o koniach na moj email<br>
            <input type="submit" value="Przejdz Dalej">
        </form>

</body>
</html>
