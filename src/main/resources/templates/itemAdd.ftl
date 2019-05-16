<#import "parts/common.ftl" as c>

<@c.page>
<h2>Добавление товара</h2>
<form action="/product/addPhone" method="post">
    <div class="form-group row">
        <label for="Name" class="col-sm-2 col-form-label">Наименование</label>
        <div class="col-sm-10">
            <input type="text" name="name" id="name" class="form-control" value="${product.name}">
        </div>
    </div>
    <div class="form-group row">
        <label for="Description" class="col-sm-2 col-form-label">Описание</label>
        <div class="col-sm-10">
            <input type="text" name="Description" id="Description" class="form-control" value="${product.options}">
        </div>
    </div>
</form>
</@c.page>