<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <ul class="nav navbar-default">
        <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">Список пользователей</a>
            </li>
         <li class="nav-item">
             <a class="nav-link" href="/contract/list">Список договоров</a>
         </li>
        <li class="nav-item">
            <a class="nav-link" href="/company">Список компаний</a>
        </li>
        </#if>
        <li class="nav-item">
            <a class="nav-link" href="/item">Список товаров</a>
        </li>
    </ul>
        <#if name == "unknown">
            <a class="btn btn-outline-primary" href="/login"> Войти </a>
        <#else>
            <div class="mr-4">${name}</div>
            <@l.logout />
        </#if>
    <nav class="navbar navbar-light bg-light">
        <form class="form-inline" method="post" action="/filterMain">
            <input class="form-control mr-sm-2" name="filterMain" type="search" placeholder="Поиск" aria-label="Search">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Найти</button>
        </form>
    </nav>
    </ul>
</nav>