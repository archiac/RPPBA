<#import "parts/common.ftl" as c>
<@c.page>

<h2 class="text-center">Список компаний</h2>
       <a class="btn btn-primary" href="/company/addCompany" role="button">Добавить компанию</a>
<table class="table">
    <thead>
    <tr>
        <th>Номер компании</th>
        <th>Название</th>
        <th>Адресс компании</th>
        <th>Телефон компании</th>
        <th>Кредитный лимит</th>
        <th>Статус компании</th>
        <th>Текущая задолженность</th>
        <th>Действие</th>
    </tr>
    </thead>
    <tbody>
    <#list companies as company>
    <tr>
        <td>${company.company_id}</td>
        <td>${company.company_name}</td>
        <td>${company.address}</td>
        <td>${company.getCompany_phone}</td>
        <td>${company.credit_lim}</td>
        <td>${company.status.status_name}</td>
        <td>${company.current_debit}</td>
        <td><a href="/company/${company.company_id}" class="btn btn-primary" role="button" aria-pressed="true">Редактировать</a>

        <form method="post" action="/company/delCompany">
            <input type="hidden" value="${company.company_id}" name="id">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button class="btn btn-danger" type="submit">      Удалить     </button>
        </form>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>
