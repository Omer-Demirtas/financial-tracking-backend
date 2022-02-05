package com.financialtracking.projection;

import java.util.List;

public interface UserView
{
    String getUsername();

    String getEmail();

    List<OrganizationView> getOrganizations();

    interface OrganizationView
    {
        String getTitle();
    }
}
