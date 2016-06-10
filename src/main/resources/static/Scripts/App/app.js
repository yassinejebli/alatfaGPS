var app = angular.module('AdminModule', ['ui.bootstrap', 'ngAnimate', 'ui.grid.moveColumns','ui.grid.rowEdit', 'ui.grid.autoResize', 'ui.grid.resizeColumns','ui.grid.exporter', 'ngResource', 'ngTouch', 'ui.grid', 'ui.grid.edit', 'ui.grid.pagination', 'ui.grid.cellNav', , 'ui.grid.selection','angularFileUpload']);
var checkboxCellEditTemplate = '<div class="checkbox" style=" margin:0px !important ;padding:0px!important;"><label style="display:block !important"> <input class="ngSelectionCheckbox"   type="checkbox" ng-model="COL_FIELD" ng-input="COL_FIELD"  /></label></div>';
checkboxCellTemplate = checkboxCellEditTemplate;

app.directive('ngEnter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress", function (event) {
            if (event.which === 13) {
                scope.$apply(function () {
                    scope.$eval(attrs.ngEnter);
                });

                event.preventDefault();
            }
        });
    };
});

var lookupEquipementGpsCellEditTemplate = '<div class="ui-grid-cell-contents"><input type="text" ui-grid-editor autocomplete="off" ng-input="COL_FIELD"  style="border: none;"  autocomplete="off" ng-model="row.entity.equipementGps"' +
    'typeahead="equipementGps as equipementGps.name for equipementGps in grid.appScope.lookupFactory.getBy(\'EquipementGpss\', \'Name\', $viewValue)" ' +
    'typeahead-input-formatter="grid.appScope.lookupFactory.format(row.entity.equipementGps,\'name\')" ' +
    'typeahead-on-select=\'grid.appScope.lookupFactory.set(row.entity,"equipementGps","equipementGps", $item,"id")\' ' +
    'typeahead-wait-ms=" 100" typeahead-append-to-body="true" ' +
    'class="form-control"></div>';


var lookupChauffeurCellEditTemplate = '<div class="ui-grid-cell-contents"><input type="text" ui-grid-editor autocomplete="off" ng-input="COL_FIELD"  style="border: none;"  autocomplete="off" ng-model="row.entity.chauffeur"' +
    'typeahead="chauffeur as chauffeur.name for chauffeur in grid.appScope.lookupFactory.getBy(\'Chauffeurs\', \'Name\', $viewValue)" ' +
    'typeahead-input-formatter="grid.appScope.lookupFactory.format(row.entity.chauffeur,\'name\')" ' +
    'typeahead-on-select=\'grid.appScope.lookupFactory.set(row.entity,"chauffeur","chauffeur", $item,"id")\' ' +
    'typeahead-wait-ms=" 100" typeahead-append-to-body="true" ' +
    'class="form-control"></div>';

var lookupIconCellEditTemplate = '<div class="ui-grid-cell-contents"><input type="text" ui-grid-editor autocomplete="off"  style="border: none;"  autocomplete="off" ng-model="row.entity.icon"' +
    'typeahead="icon as icon.name for icon in grid.appScope.lookupFactory.getBy(\'Icons\', \'Name\', $viewValue)" ' +
    'typeahead-input-formatter="grid.appScope.lookupFactory.format(row.entity.icon,\'name\')" ' +
    'typeahead-on-select=\'grid.appScope.lookupFactory.set(row.entity,"icon","icon", $item,"id")\' ' +
    'typeahead-wait-ms=" 100" typeahead-append-to-body="true" ' +
    'class="form-control"></div>';

var lookupPointInteretDepartCellEditTemplate = '<div class="ui-grid-cell-contents"><input type="text" ui-grid-editor autocomplete="off"  style="border: none;"  autocomplete="off" ng-model="row.entity.pointInteretDepart"' +
    'typeahead="pointInteretDepart as pointInteretDepart.nom for pointInteretDepart in grid.appScope.lookupFactory.getBy(\'PointInterets\', \'Nom\', $viewValue)" ' +
    'typeahead-input-formatter="grid.appScope.lookupFactory.format(row.entity.pointInteretDepart,\'nom\')" ' +
    'typeahead-on-select=\'grid.appScope.lookupFactory.set(row.entity,"pointInteretDepart","pointInteretDepart", $item,"id")\' ' +
    'typeahead-wait-ms=" 100" typeahead-append-to-body="true" ' +
    'class="form-control"></div>';

var lookupPointInteretFinCellEditTemplate = '<div class="ui-grid-cell-contents"><input type="text" ui-grid-editor autocomplete="off"  style="border: none;"  autocomplete="off" ng-model="row.entity.pointInteretFin"' +
    'typeahead="pointInteretFin as pointInteretFin.nom for pointInteretFin in grid.appScope.lookupFactory.getBy(\'PointInterets\', \'Nom\', $viewValue)" ' +
    'typeahead-input-formatter="grid.appScope.lookupFactory.format(row.entity.pointInteretFin,\'nom\')" ' +
    'typeahead-on-select=\'grid.appScope.lookupFactory.set(row.entity,"pointInteretFin","pointInteretFin", $item,"id")\' ' +
    'typeahead-wait-ms=" 100" typeahead-append-to-body="true" ' +
    'class="form-control"></div>';

var lookupVehiculeCellEditTemplate = '<div class="ui-grid-cell-contents"><input type="text" ui-grid-editor autocomplete="off"  style="border: none;"  autocomplete="off" ng-model="row.entity.Vehicule"' +
    'typeahead="vehicule as vehicule.intitule for vehicule in grid.appScope.lookupFactory.getBy(\'Vehicules\', \'Intitule\', $viewValue)" ' +
    'typeahead-input-formatter="grid.appScope.lookupFactory.format(row.entity.vehicule,\'intitule\')" ' +
    'typeahead-on-select=\'grid.appScope.lookupFactory.set(row.entity,"vehicule","vehicule", $item,"id")\' ' +
    'typeahead-wait-ms=" 100" typeahead-append-to-body="true" ' +
    'class="form-control"></div>';

var lookupDateTimeDepartCellEditTemplate = '<div class="ui-grid-cell-contents"><input type="datetime-local" ui-grid-editor   style="border: none;" ng-model="row.entity.dateDepart"' +
    'class="form-control"></div>';

var lookupRoleCellEditTemplate = '<div class="ui-grid-cell-contents"><input type="text" ui-grid-editor autocomplete="off"  style="border: none;"  autocomplete="off" ng-model="row.entity.Role"' +
    'typeahead="role as role.name for role in grid.appScope.lookupFactory.getBy(\'../Roles\', \'Name\', $viewValue)" ' +
    'typeahead-input-formatter="grid.appScope.lookupFactory.format(row.entity.role,\'name\')" ' +
    'typeahead-on-select=\'grid.appScope.lookupFactory.set(row.entity,"role","role", $item,"id")\' ' +
    'typeahead-wait-ms=" 100" typeahead-append-to-body="true" ' +
    'class="form-control"></div>';



var lookupUtilisateurCellEditTemplate = '<div class="ui-grid-cell-contents"><input type="text" ui-grid-editor autocomplete="off"  style="border: none;"  autocomplete="off" ng-model="row.entity.Utilisateur"' +
    'typeahead="utilisateur as utilisateur.name for utilisateur in grid.appScope.lookupFactory.getBy(\'../Utilisateurs\', \'Name\', $viewValue)" ' +
    'typeahead-input-formatter="grid.appScope.lookupFactory.format(row.entity.utilisateur,\'name\')" ' +
    'typeahead-on-select=\'grid.appScope.lookupFactory.set(row.entity,"utilisateur","utilisateur", $item,"id")\' ' +
    'typeahead-wait-ms=" 100" typeahead-append-to-body="true" ' +
    'class="form-control"></div>';

app.factory('crudGridDataFactory', ['$http', '$resource', function ($http, $resource) {
    var restUrl = "/rest/"
    return function (type, filterText, expand,sortField) {
        var sort = "asc";
        //if (sortDirection == "desc")
        //    sort = "desc";
        //if (sortField)
        //    sortField = sortField.replace(".", "/") + ' ' + sort;
        
        if (sortField != undefined && sortField != null)
        {
            //if (sortField)
                //sortField = sortField.replace(".", "/") + ' desc';
            var queryparams = { key: "@key"/*, $inlinecount: "allpages"*/, $orderby: sortField/*, $top: pageSize, $skip: pageSize * (currentPage - 1), $orderby: sortField */ };
        } else
        {
            var queryparams = { key: "@key"/*, $inlinecount: "allpages"*//*, $top: pageSize, $skip: pageSize * (currentPage - 1), $orderby: sortField */ };
        }
        if (filterText != null && filterText != '') {
            queryparams.$filter = filterText;
        }
        if (expand != null && expand != '') {
            queryparams.$expand = expand
        }
        return $resource("", {}, {
            'getAll': { method: "GET",isArray:true, url: restUrl + type  },
            'save': { method: "POST", url: restUrl + type /*+"/post"*/},
            'update': { method: 'PUT', /*params: { key: "@key" },*/ url: restUrl + type /* + "/put?id=:key" */},
            'query': { method: 'GET',isArray:true,/* params: queryparams,*/ url: restUrl + type + filterText},
            'remove': { method: 'DELETE', params: { key: "@key" }, url: restUrl + type + "/:key" }
        });
    };
}]);


//Pour le tableau du bord (aprés chargement du DOM puis executer le code javascript )
app.directive('onLastRepeat', function() {
    return function(scope, element, attrs) {
        if (scope.$last) setTimeout(function(){
            scope.$emit('onRepeatLast', element, attrs);
        }, 1);
    };
})

app.factory('crudGridDataFactoryPage', ['$http', '$resource', function ($http, $resource) {
    var restUrl = "/rest/"
    return function (type, pageSize, currentPage, filterText, sortField, sortDirection, expand) {
        var sort = "asc";
        if (sortDirection == "desc")
            sort = "desc";
        if (sortField)
            sortField = sortField.replace(".", "/") + ' ' + sort;
        var queryparams = { key: "@key", $inlinecount: "allpages", $top: pageSize, $skip: pageSize * (currentPage - 1), $orderby: sortField };
        if (filterText != null && filterText != '') {
            queryparams.$filter = filterText;
        }
        if (expand != null && expand != '') {
            queryparams.$expand = expand
        }
        return $resource("", {}, {
            'getAll': { method: "GET", url: restUrl + type },
            'save': { method: "POST", url: restUrl + type },
            'update': { method: 'PUT', params: { key: "@key" }, url: restUrl + type + "(:key)" },
            'query': { method: 'GET', params: queryparams, url: restUrl + type + "(:key)" },
            'remove': { method: 'DELETE', params: { key: "@key" }, url: restUrl + type + "(:key)" }
        });
    };
}]);
app.constant('Animations', {
    opacity: {
        start: 'opacity: 0',
        end: 'opacity: 1'
    },
    'slide': {
        start: 'transform: translateX(-100%)',
        end: 'transform: translateX(0)'
    }
})



app.factory('lookupFactory', function ($http) {
    return {

        get: function (table, field, text) {

                var result = []
            $.ajax({
                url: '/rest/' + table +"/?size=15",
                cache: false,
                async: false,
                success: function (data) {
                    result = data;
                }
            });
            return result;
        },
        getAll: function (table) {

            var result = []
            $.ajax({
                url: '/rest/' + table,
                cache: false,
                async: false,
                success: function (data) {
                    result = data;
                }
            });
            return result;
        },
        getBy: function (table, field, text) {
            var result = []
            $.ajax({
                url: table+"/search/findAllBy"+field+"Contains?"+field.toLowerCase()+"="+text,
                cache: false,
                async: false,
                success: function (data) {
                    if(table.indexOf("../")>-1)
                        table = table.split("/")[1];
                    result = data._embedded[table];
                    //delete result["_links"];
                    for(var i=0;i<result.length;i++)
                    {
                        result[i].id = result[i]["_links"].self.href.split("/").pop();//réaffecter l'id
                    }
                }
            });
            return result;
        },
        getLastId: function (table,field) {
                var result;

            $.ajax({
                url: "/" + table + '/search/findTopByOrderBy'+field+'Desc',
                cache: false,
                async: false,
                success: function (data) {
                    result = data;
                }
            });
            return result;
        },


        set: function (item, foreignKey, relatedObject, selectedItem, primarykey) {
            //alert('eeee')

            if (selectedItem == null) {
                item[foreignKey] = null;
                item[relatedObject] = null;

            }
            else {
                item[foreignKey] = selectedItem[primarykey];
                item[relatedObject] = selectedItem;
            }
        }
        , clear: function (item, foreignKey, relatedObject, obj, label) {
            //alert("clear");
            item[foreignKey] = null;
            item[relatedObject] = null;
            obj[label] = null;
        }
        , format: function (obj, name) {

            return (obj ? obj[name] : null);
            //alert("format");
        },
        formattest: function (obj, name) {
            //varr = obj[name];
            //console.log(varr);
            //return varr;
            //alert('oui hadi hiya setect')
            return (obj ? obj[name] : null);
        }

    };

});

var rad = function(x) {
    return x * Math.PI / 180;
};

var getDistance = function(p1, p2) {
    var R = 6378137; // Earth’s mean radius in meter
    var dLat = rad(p2.lat - p1.lat);
    var dLong = rad(p2.lng - p1.lng);
    var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
        Math.cos(rad(p1.lat)) * Math.cos(rad(p2.lat)) *
        Math.sin(dLong / 2) * Math.sin(dLong / 2);
    var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    var d = R * c;
    return d; // returns the distance in meter
};

function convertDate(today) {
    var dd = today.getDate();
    var mm = today.getMonth() + 1; //January is 0!

    var yyyy = today.getFullYear();
    if (dd < 10) {
        dd = '0' + dd
    }
    if (mm < 10) {
        mm = '0' + mm
    }
    var today = mm + '/' + dd + '/' + yyyy;
    return today;
}
toastr.options = {
    "closeButton": false,
    "debug": false,
    "progressBar": false,
    "positionClass": "toast-top-right",
    "onclick": null,
    "showDuration": "200000",
    "hideDuration": "1000",
    "timeOut": "6000",
    "extendedTimeOut": "10000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
}
app.factory('notificationFactory', function () {
    return {
        success: function (text) {
            toastr.success(text ? text : "Succès");
        },
        error: function (text, title) {
            if (!title)
                title = "Erreur"
            toastr.error(text, title);
        },
        warning: function (text, title) {
            if (!title)
                title = "Warning"
            toastr.warning(text, title);
        },
        info: function (text, title) {
            if (!title)
                title = "Info"
            toastr.info(text, title);
        }
    };
});
app.directive('timespaninput', function () {

    function parser(data) {
        var converted = moment().startOf('day').add(moment.duration(data, 'H:M:s.SSS')).format('[PT]HH[H]mm[M]ss.SSS[S]');
        return converted;
    };
    function formatter(data) {
        var converted = moment().startOf('day').add(moment.duration(data)).format('HH:mm:ss.SSS');
        return converted;
    };

    return {
        require: 'ngModel',
        link: function (scope, element, attrs, ctrl) {
            ctrl.$parsers.unshift(parser);
            ctrl.$formatters.unshift(formatter);
        }
    };
});


