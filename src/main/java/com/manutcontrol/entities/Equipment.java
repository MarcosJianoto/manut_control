package com.manutcontrol.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "equipment")
public class Equipment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "equipment_sequence")
	@SequenceGenerator(name = "equipment_sequence", sequenceName = "equipment_sequence", allocationSize = 1)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	@NotNull(message = "É necessário inserir a categoria do equipamento")
	private Category category;

	@Column(name = "name", nullable = false)
	@NotNull(message = "É necessário inserir o nome do equipamento")
	private String name;

	@Column(name = "date_hour_instalation", nullable = false)
	@NotNull(message = "O equipamento precisa ter data de instalação")
	private LocalDateTime dateHourInstalation;

	@Column(name = "max_time_between_maintenance", nullable = false)
	@NotNull(message = "É necessário ter o tempo máximo entre manuteções")
	private Integer maxTimeBetweenMaintenance;

	@Column(name = "lifetime", nullable = false)
	@NotNull(message = "O tempo de vida útil do equipamento não pode ser nulo")
	private Integer lifetime;

	@Column(name = "localization", nullable = true)
	private String localization;

	@Column(name = "priority", nullable = true)
	private PriorityEquipment priority;

	@Column(name = "status", nullable = false)
	@NotNull(message = "É necessário inserir o status do equipamento")
	private StatusEquipment status;

	@Column(name = "notification_days", nullable = false)
	@NotNull(message = "É necessário informar os dias de notificação antes do vencimento")
	private Integer notificationDay;

	@Column(name = "last_maintenance_date", nullable = false)
	@NotNull(message = "A data da última manutenção do equipamento é obrigatória")
	private LocalDateTime dateLastMaintenance;

	public Equipment() {
	}

	public Equipment(Category category, String name, LocalDateTime dateHourInstalation,
			Integer maxTimeBetweenMaintenance, Integer lifetime, String localization, PriorityEquipment priority,
			StatusEquipment status, Integer notificationDay, LocalDateTime dateLastMaintenance) {

		this.category = category;
		this.name = name;
		this.dateHourInstalation = dateHourInstalation;
		this.maxTimeBetweenMaintenance = maxTimeBetweenMaintenance;
		this.lifetime = lifetime;
		this.localization = localization;
		this.priority = priority;
		this.status = status;
		this.notificationDay = notificationDay;
		this.dateLastMaintenance = dateLastMaintenance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getDateHourInstalation() {
		return dateHourInstalation;
	}

	public void setDateHourInstalation(LocalDateTime dateHourInstalation) {
		this.dateHourInstalation = dateHourInstalation;
	}

	public Integer getMaxTimeBetweenMaintenance() {
		return maxTimeBetweenMaintenance;
	}

	public void setMaxTimeBetweenMaintenance(Integer maxTimeBetweenMaintenance) {
		this.maxTimeBetweenMaintenance = maxTimeBetweenMaintenance;
	}

	public Integer getLifetime() {
		return lifetime;
	}

	public void setLifetime(Integer lifetime) {
		this.lifetime = lifetime;
	}

	public String getLocalization() {
		return localization;
	}

	public void setLocalization(String localization) {
		this.localization = localization;
	}

	public PriorityEquipment getPriority() {
		return priority;
	}

	public void setPriority(PriorityEquipment priority) {
		this.priority = priority;
	}

	public StatusEquipment getStatus() {
		return status;
	}

	public void setStatus(StatusEquipment status) {
		this.status = status;
	}

	public Integer getNotificationDay() {
		return notificationDay;
	}

	public void setNotificationDay(Integer notificationDay) {
		this.notificationDay = notificationDay;
	}

	public LocalDateTime getDateLastMaintenance() {
		return dateLastMaintenance;
	}

	public void setDateLastMaintenance(LocalDateTime dateLastMaintenance) {
		this.dateLastMaintenance = dateLastMaintenance;
	}

}
