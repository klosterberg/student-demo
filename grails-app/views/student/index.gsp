<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
    </head>
    <body>
         <div class="nav" role="navigation">
            <ul>
                <li><g:link class="create" action="create">Create</g:link></li>
            </ul>
         <div id="list-student" class="content scaffold-list" role="main">
             <f:table collection="${studentList}" properties="['firstName', 'lastName', 'birthDate']" />
             <g:formatDate date="${birthDate}"  format="dd.MM.yyyy"/>
             <!-- <g:formatDate date="${ java.time.LocalDate.now()}"  format="dd.MM.yyyy"/> -->
         </div>
        </div>
    </body>
</html>