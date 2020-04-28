package com.hotelmanagement.constant;


/*
 * This interface consists of url mappings for connector service
 *
 */
public interface NameSpaceConstants {

    public interface addMenu{
        public String URL = "/add-menu/V1.0";

    }
    public interface getMenu{
        public String URL = "/menu-details/V1.0";

    }
    public interface deletemenu{
        public String URL = "/delete-menu/V1.0";

    }

    public interface add_user{
        public String URL = "/add_user/V1.0";
    }

    public interface delete_user{
        public String URL = "/delete_user/V1.0";
    }

    public interface get_user{
        public String URL = "/get_user/V1.0";
    }

    public interface login{
        public String URL = "/login/V1.0";
    }

    public interface add_table{
        public String URL = "/add_table/V1.0";
    }
    public interface delete_table{
        public String URL = "/delete_table/V1.0";
    }

    public interface fetch_table_detail{
        public String URL = "/fetch_table_detail/V1.0";
    }

    public interface order{
        public String URL = "/order/V1.0";
    }

    public interface update_order{
        public String URL = "/update_order/V1.0";
    }

    public interface get_order_details{
        public String URL = "/get_order_details/V1.0";
    }

    public interface bill_order{
        public String URL = "/bill_order/V1.0";
    }

    public interface get_billed_details{
        public String URL = "/get_billed_details/V1.0";
    }

    public interface CommonAPIRequestMapping {
        public String HEALTH_CHECK = "/health-check";
    }





}
