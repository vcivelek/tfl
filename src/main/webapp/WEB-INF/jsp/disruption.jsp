<%@include file="include/header.jsp" %>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Transit for London</h3>
    </div>

    <div class="panel-body">
        <form:form class="form" modelAttribute="disruptionForm" role="form">

            <div class="form-group">
                <form:label path="startdate">Start Date</form:label>
                <form:input path="startdate" class="form-control" placeholder="1/1/2016" />
                <form:errors cssClass="error" path="startdate"></form:errors>
            </div>

            <div class="form-group">
                <form:label path="enddate">End Date</form:label>
                <form:input path="enddate" class="form-control" placeholder="2/1/2016" />
                <form:errors cssClass="error" path="enddate"></form:errors>
            </div>

            <div>
                <button class="btn btn-primary" type="submit">Submit</button>
                <button class="btn btn-default" type="reset">Reset</button>
            </div>

        </form:form>
    </div>
</div>

<%@include file="include/footer.jsp" %>