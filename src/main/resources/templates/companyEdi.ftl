<#import "parts/common.ftl" as c>

<@c.page>
    <h2>Редактировать компанию</h2>
    <form action="/company" method="post">

    <div class="form-group row">
    <label for="Qty" class="col-sm-2 col-form-label">Адрес компании: </label>
    <div class="col-sm-10">
    <input type="text" name="address" id="count" class="form-control" value="${company.address}">
    </div>
    </div>

    <div class="form-group row">
<label for="Price" class="col-sm-2 col-form-label">Телефон компании: </label>
    <div class="col-sm-10">
<input type="text" name="phone" id=price" class="form-control" value="${company.getCompany_phone}">
    </div>
    </div>

    <div class="form-group row">
<label for="Qty" class="col-sm-2 col-form-label">Кредитный лимит: </label>
    <div class="col-sm-10">
<input type="text" name="credit" id="unit" class="form-control" value="${company.credit_lim}">
    </div>
    </div>

    <div class="form-group row">
<label for="Qty" class="col-sm-2 col-form-label">Текущая задолженность: </label>
    <div class="col-sm-10">
<input type="text" name="debit" id="unit" class="form-control" value="${company.current_debit}">
    </div>
    </div>

    <div class="form-group row">
<label for="Qty" class="col-sm-2 col-form-label"> Статус компании: </label>
    <select name="choiceStatus" class="mdb-select md-form" data-style="btn-info">
    <#list statuses as status>
        <option value="${status.status_id}">${status.status_name}</option>
    </#list>
    </select>
    </div>


    <div>
<input type="hidden" value="${company.company_id}" name="companyId">
<input type="hidden" value="${_csrf.token}" name="_csrf">
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Сохранить</button>
        </div>
    </form>
</@c.page>