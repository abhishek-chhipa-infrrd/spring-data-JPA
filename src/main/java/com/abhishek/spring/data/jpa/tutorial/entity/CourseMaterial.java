package com.abhishek.spring.data.jpa.tutorial.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy =
            GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            optional = false
    )
//    for which perticular column forign key is applied
    @JoinColumn(
            name = "course_id",   // name of the column in the DB
            referencedColumnName = "courseId"  //name of column in the class
    )
    private Course course;

}
