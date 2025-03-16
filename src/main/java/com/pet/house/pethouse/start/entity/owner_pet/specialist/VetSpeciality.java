package com.pet.house.pethouse.start.entity.owner_pet.specialist;

public enum VetSpeciality {

    SURGERY("This specialization focuses on surgical procedures for animals, including orthopedic surgeries and emergency procedures."),
    DERMATOLOGY("Specializes in diagnosing and treating skin conditions in animals, such as allergies, infections, and rashes."),
    DENTISTRY("Focuses on dental care for animals, including treatment of oral diseases, tooth extractions, and periodontal care."),
    CARDIOLOGY("Focuses on diagnosing and treating heart diseases, such as heart murmurs, arrhythmias, and heart failure."),
    OPHTHALMOLOGY("Specializes in the diagnosis and treatment of eye diseases in animals, including cataracts, glaucoma, and vision problems."),
    ONCOLOGY("Specializes in the diagnosis, treatment, and management of cancer in animals."),
    INTERNAL_MEDICINE("Focuses on the diagnosis and treatment of complex medical conditions affecting internal organs like the liver, kidneys, and lungs."),
    NEUROLOGY("Specializes in diagnosing and treating neurological disorders in animals, such as seizures, spinal issues, and brain disorders."),
    EMERGENCY("Focuses on treating animals in critical conditions, such as trauma, poisoning, or severe infections."),
    BEHAVIOR("Specializes in diagnosing and treating behavioral problems in animals, such as anxiety, aggression, and phobias."),
    RADIOLOGY("Specializes in diagnostic imaging techniques such as X-rays, ultrasounds, and MRIs for diagnosing internal injuries or diseases."),
    ANESTHESIOLOGY("Focuses on administering anesthesia and pain management for animals during surgery or medical procedures."),
    EXOTIC_ANIMAL("Specializes in the care of exotic pets such as reptiles, birds, and small mammals."),
    REPRODUCTION("Focuses on the breeding and reproductive health of animals, including artificial insemination and fertility treatments."),
    NUTRITION("Specializes in the dietary and nutritional needs of animals, including designing specific feeding regimens and treating malnutrition."),
    PREVENTIVE_MEDICINE("Focuses on preventing diseases and health issues through vaccination programs, wellness exams, and preventive care.");

    private final String discription;


    VetSpeciality(String discription) {
        this.discription = discription;

    }

    public String getDiscription() {
        return discription;
    }


}
