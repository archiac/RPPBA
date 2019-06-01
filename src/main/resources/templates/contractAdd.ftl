<#import "parts/common.ftl" as c>

<@c.page>
<h2>Оформить договор</h2>
<form action="/contract/contractAddContr" method="post">
    <div class="container-fluid">
        <label> Выберите компанию: </label>
        <select name="choiceCompany" class="btn btn-default dropdown-toggle" data-style="btn-info">
                            <#list companies as company>
                                <option value="${company.company_id}">${company.company_name}</option>
                            </#list>
        </select>
    </div>
    <div class="container-fluid">
        <label> Ответственный: </label>
        <select name="choiceUser" class="btn btn-primary dropdown-toggle" data-style="btn-info">
                            <#list users as user>
                                <option value="${user.id}">${user.fio}</option>
                            </#list>
        </select>
    </div>
    <div class="container-fluid">
        <label> Выберите товар: </label>
        <select name="choiceProduct" class="mdb-select md-form" data-style="btn-info">
                            <#list products as product>
                                <option value="${product.product_id}">${product.product_name}</option>
                            </#list>
        </select>
    </div>
    <div class="form-group row">
        <label for="count_product" class="col-sm-2 col-form-label">Количество необходимого товара:</label>
        <div class="col-sm-10">
            <input type="text" name="count_product" id="count_product" class="form-control">
        </div>
    </div>
    <div class="form-group row">
        <label for="date_shipping" class="col-sm-2 col-form-label">Дата отправки:</label>
        <div class="col-sm-10">
            <input type="text" name="date_shipping" id="date_shipping" class="form-control">
        </div>
    </div>
    <div class="form-group row">
        <label for="date_zak" class="col-sm-2 col-form-label">Дата заказа:</label>
        <div class="col-sm-10">
            <input type="text" name="date_zak" id="date_zak" class="form-control">
        </div>
    </div>
    <div class="container-fluid">
        <label> Тип договора: </label>
        <select name="choiceDogovor" class="mdb-select md-form" data-style="btn-info">
            <option value="Долгосрочный">Долгосрочный</option>
            <option value="Краткосрочный">Краткосрочный</option>
        </select>
    </div>
    <div class="container-fluid">
        <label> Тип оплаты: </label>
        <select name="choicePayment" class="mdb-select md-form" data-style="btn-info">
            <option value="Наличные">Наличные</option>
            <option value="Безналичные">Безналичные</option>
        </select>
    </div>

    <div>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Оформить договор</button>
            </div>
</form>
</@c.page>