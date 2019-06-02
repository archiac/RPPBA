<#import "parts/common.ftl" as c>

<@c.page>

<h2 class="text-center">Список товаров</h2>
<a class="btn btn-primary" href="/product/addProduct" role="button">Добавить товар</a>
    <table class="table">
    <thead>
    <tr>
        <th>Название</th>
        <th>Количество упаковок, шт.</th>
        <th>Цена за упаковку, руб.</th>
        <th>Количество в упаковке, шт.</th>
        <th>Действие</th>
    </tr>
    </thead>
    <tbody>
    <#list products as product>
        <tr>
        <td>${product.product_name}</td>
        <td>${product.count}</td>
        <td>${product.price}</td>
        <td>${product.unit}</td>
        <td><a href="/product/${product.product_id}" class="btn btn-primary" role="button" aria-pressed="true">Редактировать</a>

        <form method="post" action="/product/delProduct">
    <input type="hidden" value="${product.product_id}" name="id">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
        <button class="btn btn-danger" type="submit">      Удалить     </button>
        </form>
        </td>
        </tr>
    </#list>
    </tbody>
    </table>
</@c.page>
