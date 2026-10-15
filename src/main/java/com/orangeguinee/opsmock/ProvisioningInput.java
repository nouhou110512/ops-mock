package com.orangeguinee.opsmock;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Parametres d'entree de l'action CREATION_ACTIVATION_PREPAID_AUC_4G
 * (memes noms de champs que ProvisioningInput du projet OPS).
 */
public class ProvisioningInput {

    @NotBlank(message = "Le requestId ne peut etre null")
    private String requestId;

    @NotNull(message = "Le typeAction doit etre defini")
    private String typeAction;

    @NotBlank(message = "Le numero est obligatoire")
    private String numero;

    @NotBlank(message = "La sim est obligatoire")
    private String sim;

    private String profil;
    private String cle = "0";
    private boolean is4G;
    private boolean isGD;

    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }
    public String getTypeAction() { return typeAction; }
    public void setTypeAction(String typeAction) { this.typeAction = typeAction; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getSim() { return sim; }
    public void setSIM(String sim) { this.sim = sim; }
    public String getProfil() { return profil; }
    public void setProfil(String profil) { this.profil = profil; }
    public String getCle() { return cle; }
    public void setCle(String cle) { this.cle = cle; }
    public boolean isIs4G() { return is4G; }
    public void setIs4G(boolean is4G) { this.is4G = is4G; }
    public boolean isIsGD() { return isGD; }
    public void setIsGD(boolean isGD) { this.isGD = isGD; }
}
