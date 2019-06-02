<#import "parts/common.ftl" as c>

<@c.page>
    <h2>Редактировать товар</h2>
    <form action="/product" method="post">

    <div class="form-group row">
    <label for="Qty" class="col-sm-2 col-form-label">Количество упаковок, шт.</label>
    <div class="col-sm-10">
    <input type="text" name="count" id="count" class="form-control" value="${product.count}">
    </div>
    </div>

    <div class="form-group row">
<label for="Price" class="col-sm-2 col-form-label">Цена за упаковку, руб.</label>
    <div class="col-sm-10">
<input type="text" name="price" id=price" class="form-control" value="${product.price}">
    </div>
    </div>

    <div class="form-group row">
<label for="Qty" class="col-sm-2 col-form-label">Количество в упаковке, шт.</label>
    <div class="col-sm-10">
<input type="text" name="unit" id="unit" class="form-control" value="${product.unit}">
    </div>
    </div>



    <div>
<input type="hidden" value="${product.product_id}" name="productId">
<input type="hidden" value="${_csrf.token}" name="_csrf">
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Сохранить</button>
        </div>
    </form>
</@c.page>