<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <ul class="nav navbar-default">
            <li class="nav-product">
                <a class="nav-link" href="/user">Список пользователей</a>
            </li>
         <li class="nav-product">
             <a class="nav-link" href="/contract/list">Список активных договоров</a>
         </li>
        <li class="nav-product">
            <a class="nav-link" href="/company">Список компаний</a>
        </li>
        <li class="nav-product">
            <a class="nav-link" href="/product">Список товаров</a>
        </li>
        <li class="nav-product">
            <a class="nav-link" href="/contract/contractHistory">История заказов</a>
        </li>
    </ul>
        <#if name == "unknown">
            <a class="btn btn-outline-primary" href="/login"> Войти </a>
        <#else>
            <div class="mr-4">${name}</div>
            <@l.logout/>
        </#if>
    </ul>
</nav>