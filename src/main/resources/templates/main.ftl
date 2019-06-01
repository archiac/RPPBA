<#include "parts/security.ftl">
<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div class="card-deck"
    <#--<#list items as product>
        <div class="card bg-light mb-3 my-3" style="max-width: 18rem;">
        &lt;#&ndash;<#if product.getType() == "PHONE">&ndash;&gt;
            &lt;#&ndash;<div class="card-header"> ${product.type} </div>&ndash;&gt;
        &lt;#&ndash;<#else>&ndash;&gt;
        &lt;#&ndash;<div class="card-header">Ноутбук</div>&ndash;&gt;
        &lt;#&ndash;</#if>&ndash;&gt;
        <div class="card-body">
        <h5 class="card-title">${product.name}</h5>
        <p class="card-text">${product.options}</p>
            <p class="card-text">${product.description}</p>
            <p class="card-text">${product.price}</p>
            <#if isAdmin><p>${product.isexist?string}</p></#if>
            <p class="card-text">${product.qty}</p>
            <p class="card-text">${product.options}</p>
        </div>
        <div class="card-footer">
        <a href="/contract/${product.id}" class="btn btn-primary">Заказать</a>
        </div>
        </div>
    </#list>
    </div>-->
</@c.page>