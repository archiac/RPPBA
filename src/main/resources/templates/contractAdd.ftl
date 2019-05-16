<#import "parts/common.ftl" as c>

<@c.page>
<h2>Оформить договор</h2>
<form action="/contract/contractAddContr" method="post">
    <div class="container-fluid">
        <label> Выберите компанию: </label>
        <select name="choiceCompany" class="mdb-select md-form" data-style="btn-info">
                            <#list companies as company>
                                <option value="${company.company_id}">${company.company_name}</option>
                            </#list>
        </select>
    </div>


    <div class="container-fluid">
        <label> Ответственный: </label>
        <select name="choiceUser" class="mdb-select md-form" data-style="btn-info">
                            <#list users as user>
                                <option value="${user.id}">${user.fio}</option>
                            </#list>
        </select>
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

    <div class="form-group row">
        <label for="type_dog" class="col-sm-2 col-form-label">Тип договора:</label>
        <div class="col-sm-10">
            <input type="text" name="type_dog" id="type_dog" class="form-control">
        </div>
    </div>
    <div class="form-group row">
        <label for="status_dog" class="col-sm-2 col-form-label">Статус договора:</label>
        <div class="col-sm-10">
            <input type="text" name="status_dog" id="status_dog" class="form-control">
        </div>
    </div>

    <div class="form-group row">
        <label for="type_payment" class="col-sm-2 col-form-label">Тип оплаты:</label>
        <div class="col-sm-10">
            <input type="text" name="type_payment" id="type_payment" class="form-control">
        </div>
    </div>

    <div class="form-group row">
        <label for="total_sum" class="col-sm-2 col-form-label">Итоговая сумма:</label>
        <div class="col-sm-10">
            <input type="text" name="total_sum" id="total_sum" class="form-control">
        </div>
    </div>

    <div>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Оформить договор</button>
            </div>
</form>
</@c.page>