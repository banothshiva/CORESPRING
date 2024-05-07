<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<center>
    <h1 style="color:red;">LASYA BANK</h1>
    <h2 style="color:orange">EXTRA ORDINARY SERVICES</h2>
</center>
<h1 style="color:aqua">ACCOUNT DETAILS</h1>
<c:if test="${not empty details}">
    <h3 style="color:brown">WELCOME  ${name}</h3> 
        <table border="1">
            <tr>
                <th>ACCOUNT NO</th>
                <th>USERNAME</th>
                <th>AMOUNT</th>
                <th>ADDRESS</th>
                <th>PHONE</th>
            </tr>
            <tr>
                <td>${details.accountNumber}</td>
                <td>${details.name}</td>
                <td>${details.amount}</td>
                <td>${details.address}</td>
                <td>${details.mobileNumber}</td>
            </tr>
        </table>
    </c:if>
    <a href="/">HOME</a>&nbsp;&nbsp;&nbsp;
    <a href="/addAccount">NEW ACCOUNT</a>&nbsp;&nbsp;&nbsp;
    <a href="/checkBalance">BALANCE</a>&nbsp;&nbsp;&nbsp;
    <a href="/depositAmount">DEPOSIT</a>&nbsp;&nbsp;&nbsp;
    <a href="/withdrawBalance">WITHDRAW</a>&nbsp;&nbsp;&nbsp;
    <a href="/transferBalance">TRANSFER</a>&nbsp;&nbsp;&nbsp;
    <a href="/close">CLOSE</a>&nbsp;&nbsp;&nbsp;
    <a href="/about">ABOUT</a>&nbsp;&nbsp;&nbsp;