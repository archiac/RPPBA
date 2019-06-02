<#import "parts/common.ftl" as c>

<@c.page>
<h2>Изменить скидку</h2>
<form action="/contract/changeDisc" method="post">
    <input type="hidden" value="${contract.dog_id}" name="contrId">
    <div class="form-group row">
        <label for="company_name" class="col-sm-2 col-form-label">Название компании:</label>
        <div class="col-sm-10">
            ${contract.company.company_name}
        </div>
    </div>
    <div class="form-group row">
        <label for="fio" class="col-sm-2 col-form-label">Ответственный:</label>
        <div class="col-sm-10">
            ${contract.user.fio}
        </div>
    </div>
    <div class="form-group row">
        <label for="date_shipping" class="col-sm-2 col-form-label">Дата отправки:</label>
        <div class="col-sm-10">
            ${contract.date_shipping}
        </div>
    </div>
    <div class="form-group row">
        <label for="date_zak" class="col-sm-2 col-form-label">Дата отправки:</label>
        <div class="col-sm-10">
            ${contract.date_zak}
        </div>
    </div>
    <div class="form-group row">
        <label for="date_zak" class="col-sm-2 col-form-label">Тип договора:</label>
        <div class="col-sm-10">
            ${contract.type_dog}
        </div>
    </div>
    <div class="form-group row">
        <label for="type_dog" class="col-sm-2 col-form-label">Тип договора:</label>
        <div class="col-sm-10">
            ${contract.type_dog}
        </div>
    </div>
    <div class="form-group row">
        <label for="type_dog" class="col-sm-2 col-form-label">Тип оплаты:</label>
        <div class="col-sm-10">
            ${contract.type_payment}
        </div>
    </div>
    <div class="form-group row">
        <label for="discount" class="col-sm-2 col-form-label">Текущая скидка:</label>
        <div class="col-sm-10">
            ${contract.company.status.discount}%
        </div>
    </div>

    <div class="form-group row">
        <label for="new_discount" class="col-sm-2 col-form-label">Новая скидка:</label>
        <div class="col-sm-10">
            <input type="text" name="new_discount" id="new_discount" class="form-control">
        </div>
    </div>
    <div>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </div>
</form>
</@c.page>