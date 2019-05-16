
<#import "parts/common.ftl" as c>

<@c.page>

<h2 class="text-center">Список договоров</h2>
    <a class="btn btn-primary" href="/contract/addContract" role="button">Создать контракт</a>
<table class="table">
    <thead>
    <tr>
        <th>Номер договора</th>
        <th>Дата заказа</th>
        <th>Ответственный за заключение</th>
        <th>Дата отправки</th>
        <th>Название компании</th>
        <th>Сумма договора</th>
        <th>Тип оплаты</th>
        <th>Статус договора</th>
    </tr>
    </thead>
    <tbody>
    <#list contracts as contract>
    <tr>
        <td>${contract.dog_id}</td>
        <td>${contract.date_zak}</td>
        <td>${contract.user.fio}</td>
        <td>${contract.date_shipping}</td>
        <td>${contract.company.company_name}</td>
        <td>${contract.total_sum}</td>
        <td>${contract.type_payment}</td>
        <td>${contract.status_dog}</td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>
