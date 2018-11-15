<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sklep Koni</title>
</head>
<body>
        <form action="rodoCheck">
            <h1>Musisz zaakceptowac polityke prywatnosci, aby wejsc do sklepu!</h1><br>
            <input type="checkbox" name="rodo" value="rodoStart" required="required">Akceptuje polityke prywatnosci.<br>
            <input type="checkbox" name="rodoEmail" value="email">Chce otrzymywac powiadomienia na email o nowych koniach w sklepie. Tu podaj email:
            <input type="text" name="email"><br>

            <input type="submit" value="Przejdz Dalej">
        </form>
   
</body>
</html>
