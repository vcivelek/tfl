<%@include file="include/header.jsp" %>

<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Transit for London</h3>
    </div>

    <div class="panel-body">
        <form:form class="form" modelAttribute="disruptionForm" role="form">
            <div class='col-md-5'>
                <div class="form-group">

                    <form:select path="severity" class="form-control">
                        <form:option value="All">All</form:option>
                        <form:option value="Minimal">Minimal</form:option>
                        <form:option value="Moderate">Moderate</form:option>
                        <form:option value="Severe">Severe</form:option>
                    </form:select>
                </div>
            </div>

            <div class='col-md-5'>
                <div class="form-group">
                    <div class='input-group date' id='datetimepicker1'>
                        <form:input path="enddate" type='text' class="form-control" placeholder="Date (Default:Today)" id="enddate" />
                        <span class="input-group-addon">
                            <span class="glyphicon glyphicon-calendar"></span>
                        </span>
                    </div>

                </div>
            </div>

            <div>
                <button class="btn btn-primary" type="submit">Submit</button>
                <button class="btn btn-default" type="reset">Reset</button>
            </div>

        </form:form>
    </div>
</div>
<%@include file="include/footer.jsp" %>
<script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datetimepicker({
                format: 'YYYY-MM-DD'
        });
    });
</script>