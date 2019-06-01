<#import "parts/common.ftl" as c>

<@c.page>
<h2>Оформить договор</h2>
<form action="/company/companyAddCompany" method="post">
    <div class="form-group row">
        <label for="company_name" class="col-sm-2 col-form-label">Название компании:</label>
        <div class="col-sm-10">
            <input type="text" name="company_name" id="company_name" class="form-control">
        </div>
    </div>
    <div class="form-group row">
        <label for="address" class="col-sm-2 col-form-label">Адрес компании:</label>
        <div class="col-sm-10">
            <input type="text" name="address" id="address" class="form-control">
        </div>
    </div>
    <div class="form-group row">
        <label for="company_phone" class="col-sm-2 col-form-label">Телефон компании:</label>
        <div class="col-sm-10">
            <input type="text" name="company_phone" id="company_phone" class="form-control">
        </div>
    </div>
    <div class="form-group row">
        <label for="credit_lim" class="col-sm-2 col-form-label">Кредитный лимит:</label>
        <div class="col-sm-10">
            <input type="text" name="credit_lim" id="credit_lim" class="form-control">
        </div>
    </div>

    <div class="container-fluid">
        <label> Статус компании: </label>
        <select name="choiceStatus" class="mdb-select md-form" data-style="btn-info">
                            <#list statuses as status>
                                <option value="${status.status_id}">${status.status_name}</option>
                            </#list>
        </select>
    </div>

    <div class="form-group row">
        <label for="current_debit" class="col-sm-2 col-form-label">Текущая задолженность:</label>
        <div class="col-sm-10">
            <input type="text" name="current_debit" id="current_debit" class="form-control">
        </div>
    </div>
    <div>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Добавть компанию</button>
            </div>
</form>
</@c.page>