<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
    <span><a href="/user">User list</a></span>
</div>
<div>
    <form method="post">
        <input type="x" name="x" placeholder="Введіть значення по x" />
        <input type="x" name="y" placeholder="Введіть значення по y">
        <input type="x" name="description" placeholder="Введіть опис">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список повідомлень</div>
<form method="get" action="/main">
    <input type="x" name="filter" value="${filter}">
    <button type="submit">Найти</button>
</form>
<#list messages as map>
<div>
    <b>${map.id}</b>
    <span>${map.x}</span>
    <i>${map.y}</i>
    <strong>${map.authorName}</strong>
</div>
<#else>
No map
</#list>
</@c.page>
