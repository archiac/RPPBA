<#import "parts/common.ftl" as c>

<@c.page>
<h2>Добавить товар</h2>
<form action="/product/productAddproduct" method="post">
    <div class="form-group row">
        <label for="product_name" class="col-sm-2 col-form-label">Название товара:</label>
        <div class="col-sm-10">
            <input type="text" name="product_name" id="product_name" class="form-control">
        </div>
    </div>
    <div class="form-group row">
        <label for="count" class="col-sm-2 col-form-label">Количество:</label>
        <div class="col-sm-10">
            <input type="text" name="count" id="count" class="form-control">
        </div>
    </div>
    <div class="form-group row">
        <label for="price" class="col-sm-2 col-form-label">Цена:</label>
        <div class="col-sm-10">
            <input type="text" name="price" id="price" class="form-control">
        </div>
    </div>
    <div class="form-group row">
        <label for="unit" class="col-sm-2 col-form-label">Единицы хранения:</label>
        <div class="col-sm-10">
            <input type="text" name="unit" id="unit" class="form-control">
        </div>
    </div>
    <div>
        <input type="hidden" value="${_csrf.token}" name="_csrf">
        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Добавть товар</button>
            </div>
</form>
</@c.page>