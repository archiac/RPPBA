<#import "parts/common.ftl" as c>

<@c.page>

<h2 class="text-center">Список товаров</h2>
<a class="btn btn-primary" href="/product/addProduct" role="button">Добавить товар</a>
<table class="table">
    <thead>
    <tr>
        <th>Название</th>
        <th>Количество</th>
        <th>Цена</th>
        <th>Единицы измерения</th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
    <tr>
        <td>${product.product_name}</td>
        <td>${product.count}</td>
        <td>${product.price}</td>
        <td>${product.unit}</td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>
