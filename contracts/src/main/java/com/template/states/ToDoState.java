package com.template.states;

import com.template.contracts.TemplateContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.LinearState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

@BelongsToContract(TemplateContract.class)
public class ToDoState implements ContractState, LinearState {
    private Party assignedBy;
    private Party assignedTo;
    private String taskDescription;
    private UniqueIdentifier linearId = new UniqueIdentifier();

    public ToDoState(Party assignedTo, Party assignedBy, String taskDescription){
        this.assignedBy = assignedBy;
        this.assignedTo = assignedTo;
        this.taskDescription = taskDescription;
    }

    public Party getAssignedBy() {
        return assignedBy;
    }

    public Party getAssignedTo(){
        return assignedTo;
    }

    public String getTaskDescription(){
        return taskDescription;
    }

    @NotNull
    @Override
    public UniqueIdentifier getLinearId() {
        return linearId;
    }

    @NotNull
    @Override
    public List<AbstractParty> getParticipants() {
        return Arrays.asList(assignedBy, assignedTo);
    }
}
