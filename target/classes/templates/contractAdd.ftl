<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
    <h2>Оформить договор</h2>
    <form action="/contract/contractAddContr" method="post">

    <div class="form-group row">
    <label> Выберите компанию:    </label>
    <select name="choiceCompany" class="mdb-select md-form" data-style="btn-info">
    <#list companies as company>
        <option value="${company.company_id}">${company.company_name}</option>
    </#list>
    </select>
    </div>

    <div class="form-group row">
    <label> Ответственный:              ${fio} </label>
<input type="hidden" value="${id}" name="choiceUser" class="form-control">
    </div>


    <div class="form-group row">
<label> Выберите товар:            </label>
    <select name="choiceProduct" class="mdb-select md-form" data-style="btn-info">
    <#list products as product>
        <option value="${product.product_id}">${product.product_name}</option>
    </#list>
    </select>
    </div>
<h5></h5>
<div class="form-group row">
    <label for="count_product" >Количество упаковок:</label>
    <div class="col-sm-10">
        <input type="number" name="count_product" id="count_product"  >
    </div>
</div>

<div class="form-group row">
    <label for="date_shipping">Дата отправки:            </label>
    <div class="col-sm-10">
        <input type="date" name="date_shipping" id="date_shipping" >
    </div>
</div>

<div class="form-group row">
    <label for="date_zak">Дата заказа:                  </label>
    <div class="col-sm-10">
        <input type="date" name="date_zak" id="date_zak" >
    </div>
</div>

<div class="form-group row">
    <label> Тип договора:                 </label>
    <select name="choiceDogovor" class="mdb-select md-form" data-style="btn-info">
        <option value="Долгосрочный">Долгосрочный</option>
        <option value="Краткосрочный">Краткосрочный</option>
    </select>
</div>

<div class="form-group row">
    <label> Тип оплаты:                     </label>
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