<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    fio = user.getFio()
    id = user.getId()
    isAdmin = user.getAuthorities()?seq_contains('BOSS')
    user_auth = true
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    user_auth = false
    >
</#if>